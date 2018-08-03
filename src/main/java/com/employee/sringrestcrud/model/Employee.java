package com.employee.sringrestcrud.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by govinduk on 03-08-2018.
 */
@Entity
@Table(name = "emp")
public class Employee implements Serializable {
    @Id
    private  long id;
    @NotNull
    private  String empname;
    @NotNull
    private String city;
    @NotNull @Min(2000)
    private long salary;
    @NotNull
    private String comapny;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmpname() {
        return empname;
    }

    public void setEmpname(String empname) {
        this.empname = empname;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    public String getComapny() {
        return comapny;
    }

    public void setComapny(String comapny) {
        this.comapny = comapny;
    }
}
