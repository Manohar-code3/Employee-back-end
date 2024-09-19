package net.javaguide3.ems.backend.respository;

import net.javaguide3.ems.backend.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRespository extends JpaRepository<Employee,Long> {
}