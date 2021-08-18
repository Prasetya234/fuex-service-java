package com.service.fuex.web.service;

import com.service.fuex.web.model.LocationOrder;
import com.service.fuex.web.model.Vocher;
import com.service.fuex.web.response.CommonResponse;

import java.util.List;
import java.util.Map;

public interface LocationOrderService {

    List<LocationOrder> getAll();

    LocationOrder create(LocationOrder order);

    CommonResponse<Vocher> update(Long id, LocationOrder order);

    CommonResponse<Map<String, Boolean>> delete(Long id);
}
