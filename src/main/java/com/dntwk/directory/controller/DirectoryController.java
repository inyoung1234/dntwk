package com.dntwk.directory.controller;

import com.dntwk.comm.ApiStatus;
import com.dntwk.comm.PostRequestIdentifier;
import com.dntwk.directory.dto.ModDirectoryDTO;
import com.dntwk.directory.dto.SortedDirectoryListDTO;
import com.dntwk.directory.service.DirectoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class DirectoryController {

    private final DirectoryService directoryService;

    @GetMapping("/directory")
    public List<SortedDirectoryListDTO> findSortedDirectoryList(){
        return directoryService.findSortedDirectoryList();
    }

    @PostMapping("/directory/{value}")
    public ApiStatus modDirectory(@PathVariable("value") PostRequestIdentifier postRequestIdentifier,ModDirectoryDTO originalDirectoryDTO,ModDirectoryDTO modDirectoryDTO){
        return directoryService.modDirectory(postRequestIdentifier,originalDirectoryDTO,modDirectoryDTO);
    }

    @DeleteMapping("/directory")
    public ApiStatus deleteDirectory(ModDirectoryDTO modDirectoryDTO){
        return directoryService.removeDirectory(modDirectoryDTO);
    }

}
