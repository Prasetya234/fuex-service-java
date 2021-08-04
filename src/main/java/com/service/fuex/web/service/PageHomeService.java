package com.service.fuex.web.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PageHomeService {

    public ResponseEntity<String> customHeader() {
        return ResponseEntity.ok().body(String.valueOf(new Date()) + "  Fuex-BackEnd");
    }
}
