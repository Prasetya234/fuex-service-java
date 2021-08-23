package com.service.fuex.web.service;

import com.service.fuex.web.exception.ResourceNotFoundExceotion;
import com.service.fuex.web.model.Order;

import java.util.List;
import java.util.Map;

public interface OrderService {
    List<Order> getAll();

    List<Order> getOrderUserById(Long orderId);

    Order create(Order order) throws ResourceNotFoundExceotion;

    Order update(Long id, Order order);

    Map<String, Boolean> delete(Long id);
}
