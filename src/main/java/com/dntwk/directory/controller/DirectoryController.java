package com.dntwk.directory.controller;

import com.dntwk.directory.service.DirectoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class DirectoryController {

    private final DirectoryService directoryService;

}
