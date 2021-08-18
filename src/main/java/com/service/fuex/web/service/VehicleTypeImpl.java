package com.service.fuex.web.service;

import com.service.fuex.web.model.VehicleType;
import com.service.fuex.web.repository.FuelTypeRepository;
import com.service.fuex.web.repository.VehicleTypeRepository;
import com.service.fuex.web.response.CommonResponse;
import com.service.fuex.web.response.CommonResponseGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class VehicleTypeImpl implements VehicleTypeService {

    @Autowired
    private FuelTypeRepository fuelTypeRepository;

    @Autowired
    private VehicleTypeRepository vehicleTypeRepository;

    @Autowired
    private CommonResponseGenerator commonResponseGenerator;

    @Override
    public CommonResponse<List<VehicleType>> getAll() {
        return commonResponseGenerator.successResponse(vehicleTypeRepository.findAll());
    }

    @Override
    public CommonResponse<VehicleType> getById(Long id) {
        var QPWDIJQ98 = vehicleTypeRepository.findById(id).get();
        if (QPWDIJQ98 == null) {
            return commonResponseGenerator.failResponse("ID NOT FOUND");
        }
        return commonResponseGenerator.successResponse(QPWDIJQ98);
    }

    @Override
    public CommonResponse<VehicleType> create(VehicleType vehicle) {
        var KNJ72 = vehicleTypeRepository.save(vehicle);
        return commonResponseGenerator.successResponse(KNJ72);
    }

    @Override
    public CommonResponse<VehicleType> update(Long id, VehicleType vehicle) {
        var QPWDIJQ98 = vehicleTypeRepository.findById(id).get();
        if (QPWDIJQ98 == null) {
            return commonResponseGenerator.failResponse("ID NOT FOUND");
        }
        QPWDIJQ98.setTipeKendaraan(vehicle.getTipeKendaraan());
        return commonResponseGenerator.successResponse(vehicleTypeRepository.save(QPWDIJQ98));
    }

    @Override
    public CommonResponse<Map<String, Boolean>> delete(Long id) {
        var QPWDIJQ98 = vehicleTypeRepository.findById(id).get();
        if (QPWDIJQ98 == null) {
            return commonResponseGenerator.failResponse("ID NOT FOUND");
        }
        vehicleTypeRepository.deleteById(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("DELETED", Boolean.TRUE);
        return commonResponseGenerator.successResponse(response);
    }
}
