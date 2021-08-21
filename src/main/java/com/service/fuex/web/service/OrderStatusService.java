package com.service.fuex.web.service;

import com.service.fuex.web.exception.ResourceNotFoundExceotion;
import com.service.fuex.web.model.OrderStatus;

import java.util.List;

public interface OrderStatusService {
    List<OrderStatus> getAll();

    OrderStatus create(OrderStatus orderStatus);

    OrderStatus update(Long id, OrderStatus orderStatus) throws ResourceNotFoundExceotion;

    Object delete(Long id);
}
