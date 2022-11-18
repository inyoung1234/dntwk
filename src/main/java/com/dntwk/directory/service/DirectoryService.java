package com.dntwk.directory.service;

import com.dntwk.comm.ApiStatus;
import com.dntwk.comm.PostRequestIdentifier;
import com.dntwk.directory.dto.CreateDirectoryDTO;
import com.dntwk.directory.dto.ModDirectoryDTO;
import com.dntwk.directory.dto.SortedDirectoryListDTO;
import com.dntwk.directory.entity.Directory;
import com.dntwk.directory.repository.DirectoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
@Service
@Transactional
public class DirectoryService {

    private final DirectoryRepository directoryRepository;
    private final EntityManagerFactory entityManagerFactory;

    public List<SortedDirectoryListDTO> findSortedDirectoryList() {
        EntityManager em = entityManagerFactory.createEntityManager();
        TypedQuery<SortedDirectoryListDTO> query =
                em.createQuery("Select new com.dntwk.directory.dto.SortedDirectoryListDTO(d.directoryName,d.directoryLayer) " +
                        "FROM Directory d", SortedDirectoryListDTO.class);
        List<SortedDirectoryListDTO> list = query.getResultList();
        em.close();
        return list;
    }

    /*1. 객체가 있는지 확인
     * 2. superName이 유효한지 확인 - 아 여기서 단일테이블로 만든 단점이 또..
     * 3. 넣기*/
    public ApiStatus createDirectory(CreateDirectoryDTO createDirectoryDTO) {
        Directory directory = directoryRepository.findByDirectoryNameEqualsAndDirectoryLayerEquals(createDirectoryDTO.getDirectoryName(), createDirectoryDTO.getDirectoryLayer());
        if (directory == null) {
            if (createDirectoryDTO.getDirectoryLayer()!=0) {
                List<SortedDirectoryListDTO> list = this.findSortedDirectoryList();
                for (SortedDirectoryListDTO list2 : list) {
                    if (list2.getDirectoryLayer().equals(createDirectoryDTO.getDirectoryLayer() - 1)
                            && list2.getDirectoryName().equals(createDirectoryDTO.getSuperDirectoryName())) {
                        directoryRepository.save(createDirectoryDTO.toEntity());
                        return ApiStatus.SUCCESS;
                    }
                    ;
                }
            } else {
                directoryRepository.save(createDirectoryDTO.toEntity());
                return ApiStatus.SUCCESS;
            }
        }

        return ApiStatus.FAIL;
    }

    public ApiStatus modDirectory(PostRequestIdentifier postRequestIdentifier, ModDirectoryDTO originalDirectoryDTO, ModDirectoryDTO modDirectoryDTO) {
        switch (postRequestIdentifier) {
            case NAME: return this.modDirectoryName(originalDirectoryDTO, modDirectoryDTO);
            case LAYER: return this.modDirectoryLayer(originalDirectoryDTO, modDirectoryDTO);
            case SORTED: return this.modDirectorySort(originalDirectoryDTO, modDirectoryDTO);
        }

        return ApiStatus.FAIL;
    }

    public ApiStatus modDirectorySort(ModDirectoryDTO originalDirectoryDTO, ModDirectoryDTO modDirectoryDTO){
        EntityManager em = entityManagerFactory.createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        TypedQuery<Directory> query = em.createQuery("select d from Directory as d", Directory.class);
        List<Directory> directoryList = query.getResultList();
        for(Directory directory : directoryList){
            if(Objects.equals(directory.getDirectoryLayer(), modDirectoryDTO.getDirectoryLayer()) &&directory.getSuperDirectoryName().equals(modDirectoryDTO.getSuperDirectoryName())){
                if(directory.getDirectorySortedNum()< originalDirectoryDTO.getDirectorySortedNum()&&directory.getDirectorySortedNum()>= modDirectoryDTO.getDirectorySortedNum()){
                    directory.modDirectorySortNum(directory.getDirectorySortedNum()+1);
                }
            }
            if(Objects.equals(directory.getDirectoryLayer(), modDirectoryDTO.getDirectoryLayer()) &&directory.getSuperDirectoryName().equals(modDirectoryDTO.getSuperDirectoryName())
            &&directory.getDirectoryName().equals(originalDirectoryDTO.getDirectoryName())){
                directory.modDirectorySortNum(modDirectoryDTO.getDirectorySortedNum());
                em.flush();
                em.detach(directory);
            }
        }
        et.commit();
        em.close();
        return ApiStatus.SUCCESS;
    }

    public ApiStatus modDirectoryName(ModDirectoryDTO originalDirectoryDTO, ModDirectoryDTO modDirectoryDTO) {
        Directory directory = directoryRepository.findByDirectoryNameEqualsAndDirectoryLayerEqualsAndSuperDirectoryNameEqualsAndDirectorySortedNumEquals(
                originalDirectoryDTO.getDirectoryName(), originalDirectoryDTO.getDirectoryLayer(), originalDirectoryDTO.getSuperDirectoryName(), originalDirectoryDTO.getDirectorySortedNum()
        );
        if (directory != null) {
            directory.modDirectoryName(modDirectoryDTO.getDirectoryName());
            directoryRepository.save(directory);
            return ApiStatus.SUCCESS;
        }
        return ApiStatus.FAIL;
    }

    public ApiStatus modDirectoryLayer(ModDirectoryDTO originalDirectoryDTO, ModDirectoryDTO modDirectoryDTO) {
        // same layer's directoryName is Unique
        if (directoryRepository.findByDirectoryNameEqualsAndDirectoryLayerEquals(originalDirectoryDTO.getDirectoryName(), originalDirectoryDTO.getDirectoryLayer()) != null) {

            EntityManager em = entityManagerFactory.createEntityManager();
            EntityTransaction et = em.getTransaction();
            et.begin();
            TypedQuery<Directory> query = em.createQuery("select d from Directory as d", Directory.class);
            List<Directory> directoryList = query.getResultList();

            //레이어 등급은 바뀌지 않는 경우
            //1. 레이어 위치 변경
            //2. 변경 될 레이어 디렉토리의 정렬
            //3. 기존에 있던 레이어 디렉토리의 순서
            //레이어 등급도 바뀌는 경우
            //4. 하위 레이어의 등급
            for(Directory directory : directoryList){
                if(directory.getDirectoryName().equals(originalDirectoryDTO.getDirectoryName())&&directory.getDirectoryLayer().equals(originalDirectoryDTO.getDirectoryLayer())){
                    //1
                    directory.modDirectoryLayer(modDirectoryDTO.getDirectoryLayer());
                    for(Directory directory1 : directoryList){
                        //2
                        if(Objects.equals(directory1.getDirectoryLayer(), modDirectoryDTO.getDirectoryLayer()) &&directory1.getSuperDirectoryName().equals(modDirectoryDTO.getSuperDirectoryName())){
                            if(directory1.getDirectorySortedNum()>= modDirectoryDTO.getDirectorySortedNum()){
                                directory1.modDirectorySortNum(directory1.getDirectorySortedNum()+1);
                            }
                        }
                        //3
                        if(Objects.equals(directory1.getDirectoryLayer(), originalDirectoryDTO.getDirectoryLayer()) &&directory1.getSuperDirectoryName().equals(originalDirectoryDTO.getSuperDirectoryName())){
                            if(directory1.getDirectorySortedNum()>= originalDirectoryDTO.getDirectorySortedNum()){
                                directory1.modDirectorySortNum(directory1.getDirectorySortedNum()-1);
                            }
                        }
                        //4
                        if(directory1.getSuperDirectoryName().equals(modDirectoryDTO.getDirectoryName())){
                            directory1.modDirectoryLayer(modDirectoryDTO.getDirectoryLayer()+1);
                        }
                    }
                    //1
                    directory.modDirectorySortNum(modDirectoryDTO.getDirectorySortedNum());
                }
            }
            et.commit();
            em.close();
        }


        return ApiStatus.SUCCESS;
    }

    public ApiStatus removeDirectory(ModDirectoryDTO modDirectoryDTO){
        directoryRepository.deleteByDirectoryNameEqualsAndDirectoryLayer(modDirectoryDTO.getDirectoryName(), modDirectoryDTO.getDirectoryLayer());
        directoryRepository.sortDirectoryWhenRemove(modDirectoryDTO.getSuperDirectoryName(), modDirectoryDTO.getDirectorySortedNum());
        return ApiStatus.SUCCESS;
    }


}