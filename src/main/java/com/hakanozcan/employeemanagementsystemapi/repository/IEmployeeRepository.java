package com.hakanozcan.employeemanagementsystemapi.repository;

import com.hakanozcan.employeemanagementsystemapi.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmployeeRepository extends JpaRepository<EmployeeEntity, Long> {
}