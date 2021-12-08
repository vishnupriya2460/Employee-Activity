package com.demo.employee.activity.fiegnclient;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import com.demo.employee.activity.model.EmployeeResponse;
import com.demo.employee.activity.model.ProjectStatus;

//@FeignClient(name = "http://EMPLOYEE-SERVICE/api/employee")
@FeignClient(name = "EMPLOYEE-SERVICE")
public interface EmployeeFeignClient {

	@GetMapping("/api/employee/get/{code}")
	public EmployeeResponse getEmployee(@PathVariable("code") Integer code);

	@PutMapping("/api/employee/update")
	public EmployeeResponse updateEmployeeProjectStatus(ProjectStatus projectStatus);

}
