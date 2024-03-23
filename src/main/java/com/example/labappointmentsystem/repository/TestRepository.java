package com.example.labappointmentsystem.repository;

import com.example.labappointmentsystem.entity.Test;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepository extends JpaRepository<Test, Long> {
    Test findByOperatorId(Long operatorId);
}
