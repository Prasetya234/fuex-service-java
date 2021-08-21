package com.service.fuex.web.controller;

import com.service.fuex.web.model.OrderStatus;
import com.service.fuex.web.response.CommonResponse;
import com.service.fuex.web.response.CommonResponseGenerator;
import com.service.fuex.web.service.OrderStatusImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reference/order-status")
public class OrderStatusController {

    @Autowired
    private OrderStatusImpl orderStatusService;

    @Autowired
    private CommonResponseGenerator commonResponseGenerator;

    @GetMapping
    public CommonResponse<OrderStatus> getAll() {
        try {
            return commonResponseGenerator.successResponse(orderStatusService.getAll());
        } catch (Exception e) {
            return commonResponseGenerator.failResponse(e.getMessage());
        }
    }

    @PostMapping
    public CommonResponse<OrderStatus> create(@RequestBody OrderStatus orderStatus) {
        try {
            return commonResponseGenerator.successResponse(orderStatusService.create(orderStatus));
        } catch (Exception e) {
            return commonResponseGenerator.failResponse(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public CommonResponse<OrderStatus> update(@PathVariable Long id, @RequestBody OrderStatus orderStatus) {
        try {
            return commonResponseGenerator.successResponse(orderStatusService.update(id, orderStatus));
        } catch (Exception e) {
            return commonResponseGenerator.failResponse(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public CommonResponse<OrderStatus> delete(@PathVariable Long id) {
        try {
            return commonResponseGenerator.successResponse(orderStatusService.delete(id));
        } catch (Exception e) {
            return  commonResponseGenerator.failResponse(e.getMessage());
        }
    }
}
