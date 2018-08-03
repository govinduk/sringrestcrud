package com.employee.sringrestcrud.controller;

import com.employee.sringrestcrud.model.Employee;
import com.employee.sringrestcrud.service.EmployeeSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Created by govinduk on 03-08-2018.
 */
@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {

    @Autowired
    EmployeeSevice employeeSevice;

    @RequestMapping( value = "/test")
    public  String test(){
        return "welcome ";
    }



    @RequestMapping(value = "/employee", method = RequestMethod.GET)
    public ResponseEntity<List<Employee>> getemployees(){
        List<Employee> employeeList =employeeSevice.findAll();
        if(employeeList==null) {
            return new ResponseEntity<List<Employee>>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<Employee>>(employeeList, HttpStatus.OK);

    }
    @RequestMapping(value = "/employee/{eid}", method = RequestMethod.DELETE)
      public ResponseEntity deleteEmployee(@PathVariable("eid")long eid){


        if(employeeSevice.findById(eid)==null) {
            return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
        }
        employeeSevice.deleteById(eid);
        return new ResponseEntity<Employee>(HttpStatus.OK);

    }
    @RequestMapping(value = "/employee", method = RequestMethod.POST)
    public ResponseEntity saveEmployee(@RequestBody Employee employee){

        employeeSevice.save(employee);
        return new ResponseEntity<Employee>(HttpStatus.OK);

    }
    @RequestMapping(value = "/employee", method = RequestMethod.DELETE)
    public ResponseEntity deleteEmployee(){

        employeeSevice.deleteAll();
        return new ResponseEntity<Employee>(HttpStatus.OK);

    }

    @RequestMapping(value = "/employee/{eid}", method = RequestMethod.POST)
    public ResponseEntity updateEmployee(@PathVariable("eid") long eid,@RequestBody Employee employee){

        if(employeeSevice.existsById(eid)){
            Employee employee1=new Employee();
            employee1.setId(employee.getId());
            employee1.setCity(employee.getCity());
            employee1.setId(employee.getId());
            employee1.setComapny(employee.getComapny());
            employee1.setSalary(employee.getSalary());
            employee1.setEmpname(employee.getEmpname());
            employeeSevice.save(employee1);

        }
        return new ResponseEntity<Employee>(HttpStatus.OK);

    }


}
