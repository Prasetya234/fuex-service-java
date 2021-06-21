package com.service.fuex.web.repository;

import com.service.fuex.web.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query(value = "select a.* from user a where a.mobile_phone_number= :mobilePhoneNumber", nativeQuery = true)
    User findByMobilePhoneNumber(int mobilePhoneNumber);

    @Query(value = "select a.* from user a where a.email= :email", nativeQuery = true)
    User findByEmail(String email);
}
