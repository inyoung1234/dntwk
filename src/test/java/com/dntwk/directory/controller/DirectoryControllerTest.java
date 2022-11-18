package com.dntwk.directory.controller;

import com.dntwk.comm.PostRequestIdentifier;
import com.dntwk.directory.dto.CreateDirectoryDTO;
import com.dntwk.directory.dto.ModDirectoryDTO;
import com.dntwk.directory.entity.Directory;
import com.dntwk.directory.repository.DirectoryRepository;
import com.dntwk.directory.service.DirectoryService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.metamodel.Metamodel;
import java.util.Date;
import java.util.List;
import java.util.Map;

@ExtendWith(MockitoExtension.class)
class DirectoryControllerTest {
//    @InjectMocks
//    private DirectoryService directoryService;
//    @Mock
//    private DirectoryRepository directoryRepository;
//
//    @Test
//    public void findTest(){
//        directoryService.createDirectory(CreateDirectoryDTO.builder()
//                .createDt(new Date())
//                .createId("1")
//                .createIp("1")
//                .directoryLayer(0)
//                .directoryName("1")
//                .directorySortedNum(1)
//                .superDirectoryName(null).build());
//
//        ModDirectoryDTO mod1 = ModDirectoryDTO.builder()
//                .directoryName("1")
//                .directoryLayer(0)
//                .directorySortedNum(1)
//                .superDirectoryName(null)
//                .build();
//        ModDirectoryDTO mod2 = ModDirectoryDTO.builder()
//                .directoryName("2")
//                .directoryLayer(0)
//                .directorySortedNum(1)
//                .superDirectoryName(null)
//                .build();
//
//        System.out.println(directoryService.findSortedDirectoryList());
//
//        directoryService.modDirectory(PostRequestIdentifier.NAME, mod1,mod2);
//    }

}