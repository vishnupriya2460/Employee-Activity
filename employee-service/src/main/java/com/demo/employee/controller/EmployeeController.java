package com.demo.employee.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.employee.model.EmployeeActivityResponseList;
import com.demo.employee.model.EmployeeRequest;
import com.demo.employee.model.EmployeeResponse;
import com.demo.employee.model.ProjectStatus;
import com.demo.employee.service.EmployeeService;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

	private static final Logger log = LoggerFactory.getLogger(EmployeeController.class);

	@Value("${server.port}")
	String port;

	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/info")
	public String getInfo() {
		return employeeService.getInfo();
	}

	@PostMapping(value = "/create")
	public String createEmployee(@RequestBody EmployeeRequest request) {
		log.info("Port : " + port);
		return employeeService.createEmployeeWithMessage(request);
	}

	@GetMapping(value = "/get-activity/{code}")
	public EmployeeActivityResponseList getEmployeeWithActivity(@PathVariable("code") Integer code) {
		log.info("Port : " + port);

		return employeeService.getEmployeeWithActivity(code);
	}

	@GetMapping(value = "/get/{code}")
	public EmployeeResponse getEmployee(@PathVariable("code") Integer code) {
		log.info("Port : " + port);

		return employeeService.getEmployee(code);
	}

	@PutMapping(value = "/update")
	public EmployeeResponse updateEmployee(@RequestBody ProjectStatus projectStatus) {
		log.info("Port : " + port);

		return employeeService.updateProjectStatus(projectStatus);
	}

	@DeleteMapping(value = "/delete/{code}")
	public void deleteEmployee(@PathVariable("code") Integer code) {
		log.info("Port : " + port);

		employeeService.deleteEmployee(code);
	}
}
