package com.service.fuex.web.service;

import com.service.fuex.web.model.FuelType;
import com.service.fuex.web.response.CommonResponse;

import java.util.List;
import java.util.Map;

public interface FuelTypeService {
    CommonResponse<List<FuelType>> getAll();

    CommonResponse<FuelType> getById(Long id);

    CommonResponse<FuelType> create(FuelType fuelType);

    CommonResponse<FuelType> update(Long id, FuelType fuelType);

    CommonResponse<Map<String,Boolean>> delete(Long id);
}
