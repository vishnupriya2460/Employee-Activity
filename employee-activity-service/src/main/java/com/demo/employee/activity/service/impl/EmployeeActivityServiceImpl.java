package com.demo.employee.activity.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.employee.activity.entity.EmployeeActivity;
import com.demo.employee.activity.exception.EmployeeActivityException;
import com.demo.employee.activity.fiegnclient.EmployeeFeignClient;
import com.demo.employee.activity.model.EmployeeActivityRequest;
import com.demo.employee.activity.model.EmployeeActivityResponse;
import com.demo.employee.activity.model.EmployeeActivityResponseList;
import com.demo.employee.activity.model.EmployeeResponse;
import com.demo.employee.activity.model.ProjectStatus;
import com.demo.employee.activity.repository.EmployeeActivityRepository;
import com.demo.employee.activity.service.EmployeeActivityService;

@Service
public class EmployeeActivityServiceImpl implements EmployeeActivityService {

	private static final Logger log = LoggerFactory.getLogger(EmployeeActivityServiceImpl.class);

	@Autowired
	EmployeeActivityRepository employeeActivityRepository;

	@Autowired
	EmployeeFeignClient employeeFeignClient;

	@Override
	public EmployeeActivityResponse createEmployeeActivity(EmployeeActivityRequest request) {
		if (request.getEmpName() == null || request.getEmpName().isEmpty() || request.getEmpName().equals("null")
				|| request.getDescription() == null || request.getDescription().isEmpty()
				|| request.getDescription().equals("null") || request.getCode() == null) {
			throw new EmployeeActivityException("Invalid data");
		}

		EmployeeResponse response;
		try {
			response = employeeFeignClient.getEmployee(request.getCode());
		} catch (Exception e) {
			throw new EmployeeActivityException("employee not found");
		}

		EmployeeActivity employeeActivity = employeeActivityRepository.findBycodeAndStatus(response.getCode(),
				request.getStatus());
		employeeActivity = new EmployeeActivity(request.getEmpName(), response.getCode(), LocalDateTime.now(),
				request.getDescription(), request.getStatus());
//		if (employeeActivity != null) {
//			employeeActivity.setDate(LocalDateTime.now());
//			employeeActivity.setDescription(request.getDescription());
//			employeeActivity.setStatus(request.getStatus());
//		} else {
//			employeeActivity = new EmployeeActivity(request.getEmpName(), response.getCode(), LocalDateTime.now(),
//					request.getDescription(), request.getStatus());
//		}

		employeeActivity = employeeActivityRepository.save(employeeActivity);
		response = employeeFeignClient
				.updateEmployeeProjectStatus(new ProjectStatus(request.getStatus(), response.getCode()));
		return new EmployeeActivityResponse(employeeActivity.getEmpName(), employeeActivity.getCode(),
				employeeActivity.getDescription(), employeeActivity.getStatus(), employeeActivity.getDate());
	}

	@Override
	public EmployeeActivityResponseList getEmployeeActivity(Integer code) {
		EmployeeResponse response;
		try {
			response = employeeFeignClient.getEmployee(code);
		} catch (Exception e) {
			throw new EmployeeActivityException("employee not found");
		}

		List<EmployeeActivity> employeeActivityRes = employeeActivityRepository.findBycode(code);
		if (employeeActivityRes == null) {
			log.info("employee activity not found  :");
			throw new EmployeeActivityException("employee activity not found");
		}

		List<EmployeeActivityResponse> list = employeeActivityRes.stream()
				.map(employeeActivity -> new EmployeeActivityResponse(employeeActivity.getEmpName(),
						employeeActivity.getCode(), employeeActivity.getDescription(), employeeActivity.getStatus(),
						employeeActivity.getDate()))
				.collect(Collectors.toList());

		return new EmployeeActivityResponseList(response, list);
	}

	@Override
	public List<EmployeeActivityResponse> getAllEmployeeActivity(Integer code) {
		try {
			employeeFeignClient.getEmployee(code);
		} catch (Exception e) {
			throw new EmployeeActivityException("employee not found");
		}

		List<EmployeeActivity> employeeActivityList = employeeActivityRepository.findBycode(code);
		if (employeeActivityList == null) {
			log.info("employee activity not found  :");
			throw new EmployeeActivityException("employee activity not found");
		}

		List<EmployeeActivityResponse> list = employeeActivityList.stream()
				.map(employeeActivity -> new EmployeeActivityResponse(employeeActivity.getEmpName(),
						employeeActivity.getCode(), employeeActivity.getDescription(), employeeActivity.getStatus(),
						employeeActivity.getDate()))
				.collect(Collectors.toList());

		return list;
	}

	@Override
	@Transactional
	public void deleteEmployeeActivity(Integer code) {
		employeeActivityRepository.deleteBycode(code);
	}

}
