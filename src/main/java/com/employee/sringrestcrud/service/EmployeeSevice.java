package com.employee.sringrestcrud.service;

import com.employee.sringrestcrud.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * Created by govinduk on 03-08-2018.
 */
@Repository
public interface EmployeeSevice  extends JpaRepository<Employee,Long> {

}
