package net.javaguide3.ems.backend.respository;

import net.javaguide3.ems.backend.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRespository extends JpaRepository<Department,Long> {
}
