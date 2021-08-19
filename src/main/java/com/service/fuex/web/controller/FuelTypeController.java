package com.service.fuex.web.controller;

import com.service.fuex.web.model.FuelType;
import com.service.fuex.web.response.CommonResponseGenerator;
import com.service.fuex.web.service.FuelTypeImpl;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(value = "reference/fuel-type", description = "Fuel Type Controller")
@RestController
@RequestMapping("/reference/fuel-type")
public class FuelTypeController {

    @Autowired
    private FuelTypeImpl fuelTypeService;

    @Autowired
    private CommonResponseGenerator commonResponseGenerator;

    @GetMapping
    public Object getAll() {
        try {
            return fuelTypeService.getAll();
        } catch (Exception e) {
            return commonResponseGenerator.failResponse(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public Object getById(@PathVariable(name = "id")Long id) {
        try {
            return fuelTypeService.getById(id);
        } catch (Exception e) {
            return commonResponseGenerator.failResponse(e.getMessage());
        }
    }

    @PostMapping("/")
    public Object create(@RequestBody FuelType fuelType) {
        try {
            return fuelTypeService.create(fuelType);
        } catch (Exception e) {
            return commonResponseGenerator.failResponse(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public Object update(@PathVariable(name = "id")Long id, @RequestBody FuelType fuel) {
        try {
            return fuelTypeService.update(id, fuel);
        } catch (Exception e) {
            return commonResponseGenerator.failResponse(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public Object delete(@PathVariable(name = "id") Long id) {
        try {
            return fuelTypeService.delete(id);
        } catch (Exception e) {
            return commonResponseGenerator.failResponse(e.getMessage());
        }
    }
}
