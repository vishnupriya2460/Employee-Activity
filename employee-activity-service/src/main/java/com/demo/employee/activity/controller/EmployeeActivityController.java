package com.demo.employee.activity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.employee.activity.model.EmployeeActivityRequest;
import com.demo.employee.activity.model.EmployeeActivityResponse;
import com.demo.employee.activity.model.EmployeeActivityResponseList;
import com.demo.employee.activity.service.EmployeeActivityService;

@RestController
@RequestMapping("/api/employee-activity")
public class EmployeeActivityController {

	@Autowired
	private EmployeeActivityService employeeActivityService;
	
	@Autowired
	Environment environment;
	
	@GetMapping("/info")
	public String getInfo()
	{
		String port = environment.getProperty("local.server.port");
		return "From server" + port;
	}

	@PostMapping(value = "/create")
	public EmployeeActivityResponse createEmployeeActivity(@RequestBody EmployeeActivityRequest request) {
		return employeeActivityService.createEmployeeActivity(request);
	}

	@GetMapping(value = "/get/{code}")
	public EmployeeActivityResponseList getEmployeeActivity(@PathVariable("code") Integer code) {
		return employeeActivityService.getEmployeeActivity(code);
	}

	@GetMapping(value = "/get-all/{code}")
	public List<EmployeeActivityResponse> getAllEmployeeActivity(@PathVariable("code") Integer code) {
		return employeeActivityService.getAllEmployeeActivity(code);
	}
	
	@DeleteMapping(value = "/delete/{code}")
	public void deleteEmployeeActivity(@PathVariable("code") Integer code) {
		employeeActivityService.deleteEmployeeActivity(code);
	}
}
