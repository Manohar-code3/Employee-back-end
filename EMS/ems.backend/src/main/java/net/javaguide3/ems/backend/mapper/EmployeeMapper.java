package net.javaguide3.ems.backend.mapper;

import net.javaguide3.ems.backend.dto.EmployeeDto;
import net.javaguide3.ems.backend.entity.Employee;

public class EmployeeMapper {
    public static EmployeeDto mapToEmployeeDto(Employee employee) {
        return new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail(),
                employee.getDepartment().getId()

        );

    }
    public static Employee mapToEmployee(EmployeeDto employeeDto) {
        Employee employee = new Employee();
        employee.setId(employeeDto.getId());
        employee.setFirstName(employeeDto.getFirstname());
        employee.setLastName(employeeDto.getLastname());
        employee.setEmail(employeeDto.getEmail());

        return employee;

    }
}
