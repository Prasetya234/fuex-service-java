package com.service.fuex.web.repository;

import com.service.fuex.web.model.ChangePasswordRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChangePasswordRequestRepository extends JpaRepository<ChangePasswordRequest, Long> {
    ChangePasswordRequest findByEmail(String email);
    ChangePasswordRequest findByCode(String code);
}
