package com.udacity.jdnd.course3.critter.service.impl;

import com.udacity.jdnd.course3.critter.entity.Customer;
import com.udacity.jdnd.course3.critter.entity.Employee;
import com.udacity.jdnd.course3.critter.exception.ObjectNotFoundException;
import com.udacity.jdnd.course3.critter.repository.EmployeeRepository;
import com.udacity.jdnd.course3.critter.service.EmployeeService;
import com.udacity.jdnd.course3.critter.user.EmployeeSkill;

import java.time.DayOfWeek;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class EmployeeServiceImpl implements EmployeeService {
    EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        if(isNullOrEmpty(employee.getName().trim())){
            throw new ObjectNotFoundException("Please type your name");
        }
        return  employeeRepository.save(employee);
    }
    private static boolean isNullOrEmpty(String str){
        if(str !=null && !str.isEmpty())
            return false;
        else
            return true;
    }

    @Override
    public Employee getEmployeeById(long employeeId) {
        Optional<Employee>employee  = employeeRepository.findById(employeeId);
        if(employee.isPresent()){
            return employee.get();
        }else{
            throw new ObjectNotFoundException("Employee not found");
        }
    }

    @Override
    public List<Employee> getAvailableEmployees(Set<EmployeeSkill> skills, DayOfWeek dayOfWeek) {
        return null;
    }
}
