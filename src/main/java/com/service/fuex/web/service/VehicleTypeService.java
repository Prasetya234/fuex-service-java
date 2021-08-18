package com.service.fuex.web.service;

import com.service.fuex.web.model.VehicleType;
import com.service.fuex.web.response.CommonResponse;

import java.util.List;
import java.util.Map;

public interface VehicleTypeService {
    CommonResponse<List<VehicleType>> getAll();

    CommonResponse<VehicleType> getById(Long vehicleTypeId);

    CommonResponse<VehicleType> create(VehicleType vehicle);

    CommonResponse<VehicleType> update(Long id, VehicleType vehicle);

    CommonResponse<Map<String, Boolean>> delete(Long vehicleTypeId);
}
