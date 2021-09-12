package com.service.fuex.web.service;

import com.service.fuex.web.exception.ResourceNotFoundExceotion;
import com.service.fuex.web.model.Order;

import java.util.List;
import java.util.Map;

public interface OrderService {
    List<Order> getAll();

    Order create(Order order) throws ResourceNotFoundExceotion;

    Order update(Long id, Order order);

    Order findById(Long id) throws ResourceNotFoundExceotion;

    Order statusOtw(Long id) throws ResourceNotFoundExceotion;

    Order statusDone(Long id) throws  ResourceNotFoundExceotion;

    Order statusCancle(Long id) throws ResourceNotFoundExceotion;

    Map<String, Boolean> delete(Long id);
}
