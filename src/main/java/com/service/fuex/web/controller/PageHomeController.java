package com.service.fuex.web.controller;

import com.service.fuex.web.service.PageHomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PageHomeController {
    @Autowired
    PageHomeService homeService;

    @GetMapping
    ResponseEntity<String> customHeader() {
        return homeService.customHeader();
    }
}
