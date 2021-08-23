package com.service.fuex.web.service;

import com.service.fuex.web.exception.ResourceNotFoundExceotion;
import com.service.fuex.web.model.Order;
import com.service.fuex.web.repository.*;
import com.service.fuex.web.response.CommonResponseGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OrderImpl implements OrderService {

    @Autowired
    private VocherRepository vocherRepository;

    @Autowired
    private OrderStatusRepository orderStatusRepository;

    @Autowired
    private FuelTypeRepository fuelTypeRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private VehicleTypeRepository vehicleTypeRepository;

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
        return null;
    }

    private Integer transactionConfirmation(Integer biayaLayanan, Integer liter, Integer discount, Integer fuelBuy, String code) throws ResourceNotFoundExceotion {
        var LS23AFN = vocherRepository.findByCode(code);
        if (LS23AFN.getExpiredDate().getTime() < new Date().getTime()) {
            throw new ResourceNotFoundExceotion("VOUCHER HAS EXPIRED");
        }
        LS23AFN.setInUseCount(LS23AFN.getInUseCount() - 1);
        if (LS23AFN.getInUseCount() < 0) {
            throw new ResourceNotFoundExceotion("THE USE OF THE VOUCHER HAS EXCEEDED THE LIMIT");
        }
        vocherRepository.save(LS23AFN);
        int harga = liter * fuelBuy;
        int discounts = harga - discount;
        if (discounts < 0) {
            throw new ResourceNotFoundExceotion("TRANSACTIONS CANNOT BE NEGATIVE");
        }
        return discounts += biayaLayanan;
    }
    private Integer transactionConfirmationNoVocher(Integer biayaLayanan, Integer liter, Integer fuelBuy) throws ResourceNotFoundExceotion {
        int harga = liter * fuelBuy;
        return harga += biayaLayanan;
    }

    @Override
    public Order create(Order order) throws ResourceNotFoundExceotion {
            Order createOrder = new Order();
            createOrder.setAtasNama(order.getAtasNama());
            createOrder.setNoTelpon(order.getNoTelpon());
            createOrder.setAlamat(order.getAlamat());
            createOrder.setMerek(order.getMerek());
            createOrder.setNumberPlat(order.getNumberPlat());
            createOrder.setLiter(order.getLiter());
            createOrder.setBiayaLayanan(order.getBiayaLayanan());
            createOrder.setVehicleType(order.getVehicleType());
            var AOIMA12VT = vehicleTypeRepository.findById(Long.valueOf(order.getVehicleType())).orElseThrow(() -> new ResourceNotFoundExceotion("VEHICLE TYPE ID NOT FOUND"));
            createOrder.setVehicleTypeId(AOIMA12VT);
            createOrder.setFuelType(order.getFuelType());
            var MLADS29FT = fuelTypeRepository.findById(Long.valueOf(createOrder.getFuelType())).orElseThrow(() -> new ResourceNotFoundExceotion("FUEL TYPE ID NOT FOUND"));
            createOrder.setFuelTypeId(MLADS29FT);
            var yyy = MLADS29FT.getCapacity() - Integer.parseInt(order.getLiter());
            if (yyy < 0) {
                throw new ResourceNotFoundExceotion(MLADS29FT.getTipeBensin() + " left " + MLADS29FT.getCapacity() + " liter" );
            }
            MLADS29FT.setCapacity(yyy);
            fuelTypeRepository.save(MLADS29FT);
            if(!"0".equals(order.getVocher())) {
                createOrder.setVocher(order.getVocher());
                var LAI210V = vocherRepository.findById(Long.valueOf(createOrder.getVocher())).orElseThrow(() -> new ResourceNotFoundExceotion("VOCHER ID NOT FOUND"));
                createOrder.setVocherId(LAI210V);
            }
            if(createOrder.getVocher() != null) {
                var transaction = this.transactionConfirmation(Integer.valueOf(createOrder.getBiayaLayanan()), Integer.valueOf(createOrder.getLiter()), createOrder.getVocherId().getDiscount(), createOrder.getFuelTypeId().getPrice(), createOrder.getVocherId().getCode());
                createOrder.setTotalPembayaran(transaction);
            } else {
                var transaction2 = this.transactionConfirmationNoVocher(Integer.valueOf(createOrder.getBiayaLayanan()), Integer.valueOf(createOrder.getLiter()), createOrder.getFuelTypeId().getPrice());
                createOrder.setTotalPembayaran(transaction2);
            }
            createOrder.setEmergency(order.getEmergency());
            if (createOrder.getEmergency().equals(true)) {
                createOrder.setOrderStatus("2");
            } else {
                createOrder.setOrderStatus("1");
            }
            var AGJ24OT = orderStatusRepository.findById(Long.valueOf(createOrder.getOrderStatus())).orElseThrow(() -> new ResourceNotFoundExceotion("ORDER STATUS ID NOT FOUND"));
            createOrder.setOrderStatusId(AGJ24OT);
            createOrder.setUsers(order.getUsers());
            createOrder.setUserId(userRepository.findById(Long.valueOf(order.getUsers())).orElseThrow(() -> new ResourceNotFoundExceotion("USER ID NOT FOUND")));
            return orderRepository.save(createOrder);
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
