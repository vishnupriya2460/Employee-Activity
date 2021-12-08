package com.demo.employee.fiegnclient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.demo.employee.model.EmployeeActivityRequest;
import com.demo.employee.model.EmployeeActivityResponse;

@FeignClient(name = "EMPLOYEE-ACTIVITY-SERVICE")
public interface EmployeeActivityFeignClient {

	@GetMapping("/info")
	public String getInfo();
	
	@PostMapping("/api/employee-activity/create")
	public EmployeeActivityResponse createEmployeeActivity(@RequestBody EmployeeActivityRequest  request);
	
	@DeleteMapping("/api/employee-activity/delete/{code}")
	public void deleteEmployee(@PathVariable("code") Integer code);
	
	@GetMapping("/api/employee-activity/get-all/{code}")
	public List<EmployeeActivityResponse> getEmployeeActivity(@PathVariable("code") Integer code);
}
