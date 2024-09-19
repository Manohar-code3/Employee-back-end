package net.javaguide3.ems.backend.service;

import net.javaguide3.ems.backend.dto.EmployeeDto;

import java.util.List;


public interface EmployeeService {
    EmployeeDto createEmployee(EmployeeDto employeeDto);
    EmployeeDto getEmployeeById(long emplyoeeid);
    List<EmployeeDto> getAllEmployee();
    EmployeeDto updateEmployee(Long emplyoeeid, EmployeeDto updatedEmployeeDto);
    void deleteEmployee(Long emplyoeeid);
//    List<EmployeeDto> getAllDeleted();
}
