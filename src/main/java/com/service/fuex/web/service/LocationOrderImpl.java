package com.service.fuex.web.service;

import com.service.fuex.web.model.LocationOrder;
import com.service.fuex.web.model.Vocher;
import com.service.fuex.web.repository.LocationOrderRepository;
import com.service.fuex.web.response.CommonResponse;
import com.service.fuex.web.response.CommonResponseGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class LocationOrderImpl implements LocationOrderService {

    @Autowired
    private LocationOrderRepository orderRepository;

    @Autowired
    private CommonResponseGenerator commonResponseGenerator;
    
    @Override
    public List<LocationOrder> getAll() {
        return orderRepository.findAll();
    }

    @Override
    public LocationOrder create(LocationOrder order) {
        return orderRepository.save(order);
    }

    @Override
    public CommonResponse<Vocher> update(Long id, LocationOrder order) {
        var lokasi = orderRepository.findById(id).get();
        if (lokasi == null) {
            return commonResponseGenerator.failResponse("LOCATION ORDER ID NOT FOUND");
        }
        lokasi.setLokasi(order.getLokasi());
        return commonResponseGenerator.successResponse(orderRepository.save(lokasi));
    }

    @Override
    public CommonResponse<Map<String, Boolean>> delete(Long id) {
        var lokasi = orderRepository.findById(id).get();
        if (lokasi == null) {
            return commonResponseGenerator.failResponse("LOCATION ORDER ID NOT FOUND");
        }
        orderRepository.deleteById(lokasi.getId());
        Map<String, Boolean> response = new HashMap<>();
        response.put("DELETED", Boolean.TRUE);
        return commonResponseGenerator.successResponse(response);
    }
}
