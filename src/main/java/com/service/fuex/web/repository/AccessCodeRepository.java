package com.service.fuex.web.repository;

import com.service.fuex.web.model.AccessCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

    @Repository
    public interface AccessCodeRepository extends JpaRepository<AccessCode, Long> {
        @Query(value = "select a.* from access_code a where a.token_code= :tokenCode", nativeQuery = true)
        AccessCode sendOtp(String tokenCode);

        @Query(value = "select b.* from access_code b where b.email= :emailKu", nativeQuery = true)
        AccessCode checkigUser(String emailKu);
    }
