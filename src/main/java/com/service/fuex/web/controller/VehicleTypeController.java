package com.service.fuex.web.controller;

import com.service.fuex.web.model.VehicleType;
import com.service.fuex.web.response.CommonResponseGenerator;
import com.service.fuex.web.service.VehicleTypeImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reference/vehicle-type")
public class VehicleTypeController {

    @Autowired
    private VehicleTypeImpl vehicleTypeService;

    @Autowired
    private CommonResponseGenerator commonResponseGenerator;

    @GetMapping
    public Object getAll() {
        try {
            return vehicleTypeService.getAll();
        } catch (Exception e) {
            return commonResponseGenerator.failResponse(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public  Object getById(@PathVariable (value = "id") Long id) {
        try {
            return vehicleTypeService.getById(id);
        } catch (Exception e) {
            return commonResponseGenerator.failResponse(e.getMessage());
        }
    }

    @PostMapping
    public Object create(@RequestBody VehicleType vehicleType) {
        try {
            return vehicleTypeService.create(vehicleType);
        } catch (Exception e) {
            return commonResponseGenerator.failResponse(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public  Object update(@PathVariable (value = "id") Long id, @RequestBody VehicleType vehicleType) {
        try {
            return vehicleTypeService.update(id, vehicleType);
        } catch (Exception e) {
            return commonResponseGenerator.failResponse(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public Object delete(@PathVariable (value = "id") Long id) {
        try {
            return vehicleTypeService.delete(id);
        } catch (Exception e) {
            return commonResponseGenerator.failResponse(e.getMessage());
        }
    }
}
