package net.javaguide3.ems.backend.controller;

import lombok.AllArgsConstructor;
import net.javaguide3.ems.backend.dto.DepartmentDto;
import net.javaguide3.ems.backend.entity.Department;
import net.javaguide3.ems.backend.service.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("api/departments")

public class  DepartmentController {
    private DepartmentService departmentService;

//    Rest api adding departement

    @PostMapping
    public ResponseEntity<DepartmentDto> createDepartment(@RequestBody DepartmentDto departmentDto) {
        DepartmentDto department=departmentService.CreateDepartment(departmentDto);
        return new ResponseEntity<>(department, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<DepartmentDto> getAllDepartments(@PathVariable("id") Long depId) {
        DepartmentDto departmentDto =departmentService.GetDepartmentById(depId);
        return ResponseEntity.ok(departmentDto);
    }

    @GetMapping()
    public ResponseEntity<List<DepartmentDto>> getAllDepartments() {
        List<DepartmentDto > departmentDtoList=departmentService.GetAllDepartment();
        return ResponseEntity.ok(departmentDtoList);
    }
    @PutMapping("{id}")
    public ResponseEntity<DepartmentDto>UpdateDepartment(@RequestBody DepartmentDto updatedepartmentDto,@PathVariable("id") Long Depid) {
        DepartmentDto departmentDto=departmentService.UpdateDepartment(Depid, updatedepartmentDto);
        return ResponseEntity.ok(departmentDto);

    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> DeleteDepartment( @PathVariable("id") Long DepId) {
        departmentService.DeleteDepartment(DepId);
        return ResponseEntity.ok("department was deleted successfully");
    }
}
