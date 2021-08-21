package com.service.fuex.web.controller;

import com.service.fuex.web.model.Order;
import com.service.fuex.web.response.CommonResponse;
import com.service.fuex.web.response.CommonResponseGenerator;
import com.service.fuex.web.service.OrderImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/order-detail")
public class OrderController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CommonResponseGenerator commonResponseGenerator;

    @Autowired
    private OrderImpl orderService;

    @GetMapping
    public CommonResponse<List<Order>> getAll() {
        try {
            return commonResponseGenerator.successResponse(orderService.getAll());
        } catch (Exception e) {
            return commonResponseGenerator.failResponse(e.getMessage());
        }
    }
}
