package net.javaguide3.ems.backend.controller;

import lombok.AllArgsConstructor;
import net.javaguide3.ems.backend.dto.EmployeeDto;
import net.javaguide3.ems.backend.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")

@AllArgsConstructor
@RestController
@RequestMapping("/api/employee")
public class EmployeeController
{

    private  EmployeeService employeeService;


    //    Add employee
    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto)
    {
        EmployeeDto SavedEmployee=employeeService.createEmployee(employeeDto);
        return new ResponseEntity<>(SavedEmployee, HttpStatus.CREATED);

    }

    //    build get employee id rest api
    @GetMapping("{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") Long Eid)
    {
        EmployeeDto employeeDto=employeeService.getEmployeeById(Eid);
        return ResponseEntity.ok(employeeDto);
    }
    //    bulid get all employee bulid api
    @GetMapping
    public ResponseEntity<List<EmployeeDto>>getAllEmployee()
    {
        List<EmployeeDto> employeeDtoList=employeeService.getAllEmployee();
        return ResponseEntity.ok(employeeDtoList);
    }

    //    update employee build api
    @PutMapping("{id}")
    public ResponseEntity<EmployeeDto>updateEmployee(@PathVariable("id") long Eid, @RequestBody EmployeeDto updatedEmployeeDto)
    {
        EmployeeDto employeeDto=employeeService.updateEmployee(Eid,updatedEmployeeDto);
        return ResponseEntity.ok(employeeDto);

    }
    @DeleteMapping("{id}")
    public  ResponseEntity<String>deleteEmployee(@PathVariable("id") long emplyeeid)
    {
        employeeService.deleteEmployee(emplyeeid);
        return ResponseEntity.ok("successfully deleted employee");
    }




}
