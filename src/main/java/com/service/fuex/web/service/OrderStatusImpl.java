package com.service.fuex.web.service;

import com.service.fuex.web.exception.ResourceNotFoundExceotion;
import com.service.fuex.web.model.OrderStatus;
import com.service.fuex.web.repository.OrderStatusRepository;
import com.service.fuex.web.response.CommonResponseGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OrderStatusImpl implements OrderStatusService {
    
    @Autowired
    private OrderStatusRepository orderStatusRepository;
    
    @Autowired
    private CommonResponseGenerator commonResponseGenerator;
    
    @Override
    public List<OrderStatus> getAll() {
        return orderStatusRepository.findAll();
    }

    @Override
    public OrderStatus create(OrderStatus orderStatus) {
        return orderStatusRepository.save(orderStatus);
    }

    @Override
    public OrderStatus update(Long id, OrderStatus orderStatus) throws ResourceNotFoundExceotion {
        var SMOQ02 = orderStatusRepository.getById(id);
        System.out.println(SMOQ02);
        if (SMOQ02 == null) {
            throw new ResourceNotFoundExceotion("ORDER STATUS ID NOT FOUND");
        }
        SMOQ02.setOrderStatusName(orderStatus.getOrderStatusName());
        return orderStatusRepository.save(SMOQ02);
    }

    @Override
    public Object delete(Long id) {
        var AIDAM21 = orderStatusRepository.getById(id);
        if (AIDAM21 == null) {
            return commonResponseGenerator.failResponse("ORDER STATUS ID NOT FOUND");
        }
        orderStatusRepository.deleteById(AIDAM21.getOrderStatusId());
        Map<String, Boolean> response = new HashMap<>();
        response.put("DELETED", Boolean.TRUE);
        return response;
    }
}
