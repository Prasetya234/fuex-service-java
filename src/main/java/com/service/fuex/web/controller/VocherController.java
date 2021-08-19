package com.service.fuex.web.controller;

import com.service.fuex.web.model.Vocher;
import com.service.fuex.web.response.CommonResponse;
import com.service.fuex.web.response.CommonResponseGenerator;
import com.service.fuex.web.service.VocherImpl;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "key/vocher", description = "Vhocers Controller")
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
