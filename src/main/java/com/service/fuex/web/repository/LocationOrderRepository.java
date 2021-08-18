package com.service.fuex.web.repository;

import com.service.fuex.web.model.LocationOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationOrderRepository extends JpaRepository<LocationOrder, Long> {
}
