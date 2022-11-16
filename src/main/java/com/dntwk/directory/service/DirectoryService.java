package com.dntwk.directory.service;

import com.dntwk.directory.DTO.CreateDirectoryDTO;
import com.dntwk.directory.repository.DirectoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
@Transactional
public class DirectoryService {

    private final DirectoryRepository directoryRepository;


    public void createDirectoy(CreateDirectoryDTO createDirectoryDTO){
    }
}