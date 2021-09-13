package com.service.fuex.web.controller;

import com.service.fuex.web.model.Vocher;
import com.service.fuex.web.response.CommonResponse;
import com.service.fuex.web.response.CommonResponseGenerator;
import com.service.fuex.web.service.VocherImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/key/vocher")
public class VocherController {

    @Autowired
    private ModelMapper modelMapper;

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

    @GetMapping("/{id}")
    public CommonResponse<Vocher> findById(@PathVariable Long id) {
        try {
            return commonResponseGenerator.successResponse(vocher.findById(id));
        } catch (Exception e) {
            return commonResponseGenerator.failResponse(e.getMessage());
        }
    }

    @GetMapping("/code")
    public CommonResponse<Vocher> getCode(@RequestParam(name = "code") String code) {
        try {
            return commonResponseGenerator.successResponse(vocher.getCode(code));
        } catch (Exception e) {
            return commonResponseGenerator.failResponse(e.getMessage());
        }
    }

    @PostMapping
    public CommonResponse<Vocher> create(@RequestBody Vocher vocher1) {
        try {

            return commonResponseGenerator.successResponse(vocher.create(vocher1));
        } catch (Exception e) {
            return commonResponseGenerator.failResponse(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public Object update(@PathVariable("id") Long id,@RequestBody Vocher vocher1) {
        try {
            return vocher.update(id, vocher1);
        } catch (Exception e) {
            return commonResponseGenerator.failResponse(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public Object delete(@PathVariable("id") Long id) {
        try {
            return vocher.delete(id);
        } catch (Exception e) {
            return commonResponseGenerator.failResponse(e.getMessage());
        }
    }
}
