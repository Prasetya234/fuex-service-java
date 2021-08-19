package com.service.fuex.web.controller;

import com.service.fuex.web.model.LocationOrder;
import com.service.fuex.web.response.CommonResponse;
import com.service.fuex.web.response.CommonResponseGenerator;
import com.service.fuex.web.service.LocationOrderImpl;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "order-detail/location-order", description = "Location Order Controller")
@RestController
@RequestMapping("/order-detail/location-order")
public class LocationOrderController {
    @Autowired
    private LocationOrderImpl locationOrder;

    @Autowired
    private CommonResponseGenerator commonResponseGenerator;

    @GetMapping
    public CommonResponse<List<LocationOrder>> getAll() {
        try {
            return commonResponseGenerator.successResponse(locationOrder.getAll());
        } catch (Exception e) {
            return commonResponseGenerator.failResponse(e.getMessage());
        }
    }

    @PostMapping
    public CommonResponse<LocationOrder> create(@RequestBody LocationOrder create) {
        try {
            return commonResponseGenerator.successResponse(locationOrder.create(create));
        } catch (Exception e) {
            return commonResponseGenerator.failResponse(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    private Object update(@PathVariable(value = "id")Long id, @RequestBody LocationOrder update) {
        try {
            return locationOrder.update(id, update);
        } catch (Exception e) {
            return commonResponseGenerator.failResponse(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    private Object delete(@PathVariable(value = "id")Long id)  {
        try {
            return locationOrder.delete(id);
        } catch (Exception e) {
            return commonResponseGenerator.failResponse(e.getMessage());
        }
    }
}
