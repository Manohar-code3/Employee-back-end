package net.javaguide3.ems.backend.mapper;

import net.javaguide3.ems.backend.dto.DepartmentDto;
import net.javaguide3.ems.backend.entity.Department;

public class DepartmentMapper {
    public static DepartmentDto mapToDepartmentDto(Department department) {
        return new DepartmentDto (department.getId(),
        department.getDep_name(),
        department.getDescription()

        );
    }
    public  static Department mapToDepartment(DepartmentDto departmentDto) {
        return new Department(
                departmentDto.getId(),
                departmentDto.getDep_name(),
                departmentDto.getDescription()
        );
    }


}
