package com.dntwk.directory.service;

import com.dntwk.comm.ApiStatus;
import com.dntwk.directory.DTO.CreateDirectoryDTO;
import com.dntwk.directory.DTO.ModDirectoryDTO;
import com.dntwk.directory.firstdirectory.repository.DirectoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
@Transactional
public class DirectoryService {

    private final DirectoryRepository directoryRepository;

    public ApiStatus createDirectoy(CreateDirectoryDTO createDirectoryDTO) {
        if (duplicateDirectoryName(createDirectoryDTO.getDirectoryName())) {
            directoryRepository.save(createDirectoryDTO.toEntity());
            return ApiStatus.SUCCESS;
        } else {
            return ApiStatus.FAIL;
        }
    }

    public boolean duplicateDirectoryName(String directoryName) {
        return directoryRepository.findByDirectoryName(directoryName) == null;
    }

    public void modifyDirectory(ModDirectoryDTO modDirectoryDTO){
        directoryRepository.save(modDirectoryDTO.toEntity());
    }
}