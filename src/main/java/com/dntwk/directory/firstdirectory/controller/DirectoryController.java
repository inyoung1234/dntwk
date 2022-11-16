package com.dntwk.directory.firstdirectory.controller;

import com.dntwk.directory.firstdirectory.service.DirectoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class DirectoryController {

    private final DirectoryService directoryService;


}
