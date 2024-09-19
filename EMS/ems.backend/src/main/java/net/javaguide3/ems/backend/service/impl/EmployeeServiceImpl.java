package net.javaguide3.ems.backend.service.impl;

import lombok.AllArgsConstructor;
import lombok.Setter;
import net.javaguide3.ems.backend.dto.EmployeeDto;
import net.javaguide3.ems.backend.entity.Department;
import net.javaguide3.ems.backend.entity.Employee;
import net.javaguide3.ems.backend.exception.Idnotfound;
import net.javaguide3.ems.backend.mapper.EmployeeMapper;
import net.javaguide3.ems.backend.respository.DepartmentRespository;
import net.javaguide3.ems.backend.respository.EmployeeRespository;
import net.javaguide3.ems.backend.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRespository employeeRespository;
    private DepartmentRespository departmentRespository;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Department department=departmentRespository.findById(employeeDto.getDepartmentid())
                .orElseThrow(() -> new Idnotfound("department not exist id :"+employeeDto.getDepartmentid()));
        employee.setDepartment(department);
        Employee savedEmployee=employeeRespository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(long emplyoeeid) {
        Employee employee=employeeRespository.findById(emplyoeeid)
                .orElseThrow(() -> new Idnotfound("Employee not found"+emplyoeeid));
        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployee() {
        List<Employee>employees=employeeRespository.findAll();
        return employees.stream().map((employee)-> EmployeeMapper.mapToEmployeeDto(employee))
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployee(Long emplyoeeid, EmployeeDto updatedEmployeeDto) {
        Employee employee= employeeRespository.findById(emplyoeeid).orElseThrow(() -> new Idnotfound("Employee not found"+emplyoeeid));

        employee.setFirstName(updatedEmployeeDto.getFirstname());
        employee.setLastName(updatedEmployeeDto.getLastname());
        employee.setEmail(updatedEmployeeDto.getEmail());
        Department department=departmentRespository.findById(updatedEmployeeDto.getDepartmentid())
                .orElseThrow(() -> new Idnotfound("department not exist id :"+updatedEmployeeDto.getDepartmentid()));
        employee.setDepartment(department);
        Employee udpdateEmployeeobject=employeeRespository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(udpdateEmployeeobject);

    }

    @Override
    public void deleteEmployee(Long emplyoeeid) {
        Employee employee=employeeRespository.findById(emplyoeeid)
                .orElseThrow(() -> new Idnotfound("Employee not found"+emplyoeeid));
        employeeRespository.deleteById(emplyoeeid);
    }


}