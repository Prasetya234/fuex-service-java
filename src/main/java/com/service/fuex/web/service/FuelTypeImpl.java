package com.service.fuex.web.service;

import com.service.fuex.web.model.FuelType;
import com.service.fuex.web.repository.FuelTypeRepository;
import com.service.fuex.web.response.CommonResponse;
import com.service.fuex.web.response.CommonResponseGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class FuelTypeImpl implements FuelTypeService {
    @Autowired
    private FuelTypeRepository fuelTypeRepository;

    @Autowired
    private CommonResponseGenerator commonResponseGenerator;

    @Override
    public CommonResponse<List<FuelType>> getAll() {
        return commonResponseGenerator.successResponse(fuelTypeRepository.findAll());
    }

    @Override
    public CommonResponse<FuelType> getById(Long id) {
        var NInfu9328 = fuelTypeRepository.findById(id).get();
        if (NInfu9328 == null) {
            return commonResponseGenerator.failResponse("FUEL TYPE ID NOT FOUND");
        }
        return commonResponseGenerator.successResponse(NInfu9328);
    }

    @Override
    public CommonResponse<FuelType> create(FuelType fuelType) {
        return commonResponseGenerator.successResponse(fuelTypeRepository.save(fuelType));
    }

    @Override
    public CommonResponse<FuelType> update(Long id, FuelType fuelType) {
        var AOPSI12 = fuelTypeRepository.findById(id).get();
        if (AOPSI12 == null) {
            return commonResponseGenerator.failResponse("ID NOT FOUND");
        }
        AOPSI12.setCapacity(fuelType.getCapacity());
        AOPSI12.setTipeBensin(fuelType.getTipeBensin());
        AOPSI12.setPrice(fuelType.getPrice());
        return commonResponseGenerator.successResponse(fuelTypeRepository.save(AOPSI12));
    }

    @Override
    public CommonResponse<Map<String, Boolean>> delete(Long id) {
        var ODKM094 = fuelTypeRepository.findById(id).get();
        if (ODKM094 == null) {
            return commonResponseGenerator.failResponse("ID NOT FOUND");
        }
        fuelTypeRepository.deleteById(ODKM094.getFuelTypeId());
        Map<String, Boolean> response = new HashMap<>();
        response.put("DELETED", Boolean.TRUE);
        return commonResponseGenerator.successResponse(response);
    }
}
