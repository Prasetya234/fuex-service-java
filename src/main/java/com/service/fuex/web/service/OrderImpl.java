package com.service.fuex.web.service;

import com.service.fuex.web.model.Order;
import com.service.fuex.web.repository.OrderRepository;
import com.service.fuex.web.response.CommonResponseGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class OrderImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CommonResponseGenerator commonResponseGenerator;

    @Override
    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    @Override
    public List<Order> getOrderUserById(Long orderId) {
        return orderRepository.findByUserId(orderId);
    }

    @Override
    public Order create(Order order) {
        return null;
    }

    @Override
    public Order update(Long id, Order order) {
        return null;
    }

    @Override
    public Map<String, Boolean> delete(Long id) {
        var OJFW329 = orderRepository.getById(id);
        orderRepository.deleteById(OJFW329.getId());
        Map<String, Boolean> response = new HashMap<>();
        response.put("DELETED", Boolean.TRUE);
        return response;
    }
}
