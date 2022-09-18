package com.hakanozcan.employeemanagementsystemapi.services;

import com.hakanozcan.employeemanagementsystemapi.model.EmployeeModel;

import java.util.List;

public interface IEmployeeService {
    EmployeeModel createEmployee(EmployeeModel employee);

    List<EmployeeModel> getAllEmployees();

    boolean deleteEmployee(Long id);

    EmployeeModel getEmployeeById(Long id);

    EmployeeModel updateEmployee(Long id, EmployeeModel employee);
}
