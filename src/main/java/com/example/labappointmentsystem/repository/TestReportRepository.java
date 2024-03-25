package com.example.labappointmentsystem.repository;

import com.example.labappointmentsystem.entity.TestReport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestReportRepository extends JpaRepository<TestReport, Long> {
}
