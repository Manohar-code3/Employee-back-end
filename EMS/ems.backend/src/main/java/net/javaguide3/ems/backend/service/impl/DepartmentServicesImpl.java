package net.javaguide3.ems.backend.service.impl;

import lombok.AllArgsConstructor;
import net.javaguide3.ems.backend.dto.DepartmentDto;
import net.javaguide3.ems.backend.dto.EmployeeDto;
import net.javaguide3.ems.backend.entity.Department;
import net.javaguide3.ems.backend.entity.Employee;
import net.javaguide3.ems.backend.exception.Idnotfound;
import net.javaguide3.ems.backend.mapper.DepartmentMapper;
import net.javaguide3.ems.backend.mapper.EmployeeMapper;
import net.javaguide3.ems.backend.respository.DepartmentRespository;
import net.javaguide3.ems.backend.service.DepartmentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DepartmentServicesImpl implements DepartmentService {
    private DepartmentRespository departmentRespository;

    @Override
    public DepartmentDto CreateDepartment(DepartmentDto departmentDto) {
        Department department = DepartmentMapper.mapToDepartment(departmentDto);
        Department SavedDepartment=departmentRespository.save(department);

        return DepartmentMapper.mapToDepartmentDto(SavedDepartment);
    }

    @Override
    public DepartmentDto GetDepartmentById(Long departmentId) {
        Department department=departmentRespository.findById(departmentId).orElseThrow(
                () -> new Idnotfound("Department not found"+departmentId)
        );

        return DepartmentMapper.mapToDepartmentDto(department);
    }

    @Override
    public List<DepartmentDto>GetAllDepartment() {
        List<Department>departments=departmentRespository.findAll();
        return  departments.stream().map((department)->DepartmentMapper.mapToDepartmentDto(department)).collect(Collectors.toList());

    }

    @Override
    public DepartmentDto UpdateDepartment(Long id, DepartmentDto updatedepartmentDto) {
        Department department=departmentRespository.findById(id).orElseThrow(() -> new Idnotfound("Department not found"+id));
        department.setDep_name(updatedepartmentDto.getDep_name());
        department.setDescription(updatedepartmentDto.getDescription());
        Department updatedDep= departmentRespository.save(department);
       return DepartmentMapper.mapToDepartmentDto(updatedDep);

    }

    @Override
    public void DeleteDepartment(Long id) {
        Department department=departmentRespository.findById(id).orElseThrow(() -> new Idnotfound("Department not found"+id));
        departmentRespository.deleteById(id);
    }


}
