package com.example.resource;

import com.example.model.Employee;
import com.example.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeResource {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping
    public List<Employee> all() {
        List<Employee> employees = new ArrayList<>();
        employeeRepository.findAll()
                .forEach(employees::add);
        return employees;
    }

    @GetMapping(path = "{id}")
    public Employee get(@PathVariable("id") Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No data found for id " + id));
    }

    @PostMapping
    public Employee create(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }

    @PutMapping(path = "{id}")
    public Employee update(@RequestBody Employee newEmployee, @PathVariable("id") Long id) {
        Employee existingEmployee = employeeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No data found for id " + id));

        existingEmployee.setName(newEmployee.getName());
        existingEmployee.setAddress(newEmployee.getAddress());

        return employeeRepository.save(existingEmployee);
    }

    @DeleteMapping(path = "{id}")
    public void delete(@PathVariable("id") Long id) {
        employeeRepository.deleteById(id);
    }

    @PostConstruct
    public void uploadInitRecords() {

        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(100l, "Alex", new String[] {"US", "ATD"}));
        employees.add(new Employee(101l, "John", new String[] {"UK", "SDF"}));
        employees.add(new Employee(102l, "Jessica", new String[] {"SA", "OL"}));
        employees.add(new Employee(103l, "Brad", new String[] {"INDIA", "DELHI"}));
        employees.add(new Employee(104l, "Joy", new String[] {"UAE", "DUBAI"}));
        employeeRepository.saveAll(employees);


    }

}
