package net.javaguide3.ems.backend.service;

import net.javaguide3.ems.backend.dto.DepartmentDto;
import net.javaguide3.ems.backend.entity.Department;

import java.util.List;

public interface DepartmentService {
    DepartmentDto CreateDepartment(DepartmentDto departmentDto);
    DepartmentDto GetDepartmentById(Long id);
    List<DepartmentDto> GetAllDepartment();
    DepartmentDto UpdateDepartment(Long id,DepartmentDto updatedepartmentDto);
    void DeleteDepartment(Long id);

}
