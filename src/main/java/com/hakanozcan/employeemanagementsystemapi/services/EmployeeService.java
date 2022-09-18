package com.hakanozcan.employeemanagementsystemapi.services;

import com.hakanozcan.employeemanagementsystemapi.entity.EmployeeEntity;
import com.hakanozcan.employeemanagementsystemapi.model.EmployeeModel;
import com.hakanozcan.employeemanagementsystemapi.repository.IEmployeeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService implements IEmployeeService {
    private IEmployeeRepository employeeRepository;
    public EmployeeService(IEmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }



    @Override
    public EmployeeModel createEmployee(EmployeeModel employee) {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        BeanUtils.copyProperties(employee, employeeEntity);
        employeeRepository.save(employeeEntity);
        return employee;
    }

    @Override
    public List<EmployeeModel> getAllEmployees() {
        List<EmployeeEntity> employeeEntities = employeeRepository.findAll();
        List<EmployeeModel> employees = employeeEntities.stream().map(emp -> {
            return new EmployeeModel(emp.getId(), emp.getFirstName(), emp.getLastName(), emp.getEmail());
        }).collect(Collectors.toList());
        return employees;
    }

    @Override
    public boolean deleteEmployee(Long id) {
        EmployeeEntity employee = employeeRepository.findById(id).get();
        employeeRepository.delete(employee);
        return true;
    }

    @Override
    public EmployeeModel getEmployeeById(Long id) {
        EmployeeEntity employeeEntity = employeeRepository.findById(id).get();
        EmployeeModel employee = new EmployeeModel();
        BeanUtils.copyProperties(employeeEntity, employee);
        return employee;
    }

    @Override
    public EmployeeModel updateEmployee(Long id, EmployeeModel employee) {
        EmployeeEntity employeeEntity = employeeRepository.findById(id).get();
        employeeEntity.setEmail(employee.getEmail());
        employeeEntity.setFirstName(employee.getFirstName());
        employeeEntity.setLastName(employee.getLastName());
        employeeRepository.save(employeeEntity);
        return employee;
    }
}