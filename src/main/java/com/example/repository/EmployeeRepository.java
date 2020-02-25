package com.example.repository;

import com.example.model.Employee;
import org.springframework.data.solr.repository.SolrCrudRepository;

public interface EmployeeRepository extends SolrCrudRepository<Employee, Long> {

}
