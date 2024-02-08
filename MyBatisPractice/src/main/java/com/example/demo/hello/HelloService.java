package com.example.demo.hello;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HelloService {

	@Autowired
	public HelloRepository repository;
	
	public Employee getEmployee(String id) {
		
		Map<String, Object> map = repository.findById(id);
		System.out.println((String)map.get("id"));
		Employee employee = new Employee();
		
		employee.setEmployeeId((String)map.get("id"));
		employee.setEmployeeName((String)map.get("name"));
		employee.setEmployeeAge((Integer)map.get("age"));
		
		return employee;
	}
}
