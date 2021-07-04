package com.service.fuex.web.repository;

import com.service.fuex.web.model.TemporaryOtp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TemporaryOtpRepository extends JpaRepository<TemporaryOtp, Long> {
    @Query(value = "select b.* from temporary_otp b where b.email= :email and b.otp_number = :otpNumber and is_verified = false", nativeQuery = true)
    TemporaryOtp checkingOtp(String otpNumber,String email);

    @Query(value = "select c.* from temporary_otp c where c.email = :email", nativeQuery = true)
    TemporaryOtp findByEmail(String email);


}
