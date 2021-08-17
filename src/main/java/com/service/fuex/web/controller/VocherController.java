package com.service.fuex.web.controller;

import com.service.fuex.web.model.Vocher;
import com.service.fuex.web.response.CommonResponse;
import com.service.fuex.web.response.CommonResponseGenerator;
import com.service.fuex.web.service.VocherImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/key/vocher")
public class VocherController {

    @Autowired
    private VocherImpl vocher;

    @Autowired
    private CommonResponseGenerator commonResponseGenerator;

    @GetMapping
    public CommonResponse<List<Vocher>> getAll(){
        try {
            return commonResponseGenerator.successResponse(vocher.getAll());
        } catch (Exception e) {
            return commonResponseGenerator.failResponse(e.getMessage());
        }
    }

    @PostMapping("/")
    public CommonResponse<Vocher> create(@RequestBody Vocher vocher1) {
        try {
            return commonResponseGenerator.successResponse(vocher.create(vocher1));
        } catch (Exception e) {
            return commonResponseGenerator.failResponse(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public CommonResponse<Vocher> update(@PathVariable("id") Long id,@RequestBody Vocher vocher1) {
        try {
            return commonResponseGenerator.successResponse(vocher.update(id, vocher1));
        } catch (Exception e) {
            return commonResponseGenerator.failResponse(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public CommonResponse<Vocher> delete(@PathVariable("id") Long id) {
        try {
            return commonResponseGenerator.successResponse(vocher.delete(id));
        } catch (Exception e) {
            return commonResponseGenerator.failResponse(e.getMessage());
        }
    }
}
