package com.service.fuex.web.repository;

import com.service.fuex.web.model.Vocher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VocherRepository extends JpaRepository<Vocher, Long> {
    Vocher findByCode(String code);
}
