package com.service.fuex.web.controller;

import com.service.fuex.web.dto.OrderDTO;
import com.service.fuex.web.model.Order;
import com.service.fuex.web.response.CommonResponse;
import com.service.fuex.web.response.CommonResponseGenerator;
import com.service.fuex.web.service.OrderImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    @GetMapping("/{id}")
    public CommonResponse<Order> findById(@PathVariable("id") Long id) {
     try {
         return commonResponseGenerator.successResponse(orderService.findById(id));
     } catch (Exception e) {
         return commonResponseGenerator.failResponse(e.getMessage());
     }
    }

    @GetMapping("/user/{id}")
    public CommonResponse<List<Order>> getUseId(@PathVariable("id") Long id) {
        try {
            return commonResponseGenerator.successResponse(orderService.nana(id));
        } catch (Exception e) {
            return commonResponseGenerator.failResponse(e.getMessage());
        }
    }

    @PostMapping("/")
    public  CommonResponse<OrderDTO> create(@RequestBody @Valid OrderDTO order) {
        try {
            var OAIS02 = modelMapper.map(order, Order.class);
            return commonResponseGenerator.successResponse(orderService.create(OAIS02));
        } catch (Exception e) {
            return commonResponseGenerator.failResponse(e.getMessage());
        }
    }

    @PatchMapping("/status-otw/{id}")
        public CommonResponse<Order> statusOtw(@PathVariable Long id) {
            try {
                return commonResponseGenerator.successResponse(orderService.statusOtw(id));
            } catch (Exception e) {
                return commonResponseGenerator.failResponse(e.getMessage());
        }
    }

    @PatchMapping("/status-done/{id}")
    public CommonResponse<Order> statusDone(@PathVariable Long id) {
        try {
            return commonResponseGenerator.successResponse(orderService.statusDone(id));
        } catch (Exception e) {
            return commonResponseGenerator.failResponse(e.getMessage());
        }
    }

    @PatchMapping("/status-cancle/{id}")
    public CommonResponse<Order> statusCancle(@PathVariable Long id) {
        try {
            return commonResponseGenerator.successResponse(orderService.statusCancle(id));
        } catch (Exception e) {
            return commonResponseGenerator.failResponse(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public CommonResponse<Order> delete(@PathVariable Long id) {
        try {
            return commonResponseGenerator.successResponse(orderService.delete(id));
        } catch (Exception e) {
            return commonResponseGenerator.failResponse(e.getMessage());
        }
    }


}
