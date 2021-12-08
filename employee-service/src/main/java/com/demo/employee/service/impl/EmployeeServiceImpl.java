package com.demo.employee.service.impl;

import java.security.SecureRandom;
import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.employee.entity.Employee;
import com.demo.employee.exception.EmployeeException;
import com.demo.employee.fiegnclient.EmployeeActivityFeignClient;
import com.demo.employee.model.EmployeeActivityRequest;
import com.demo.employee.model.EmployeeActivityResponse;
import com.demo.employee.model.EmployeeActivityResponseList;
import com.demo.employee.model.EmployeeRequest;
import com.demo.employee.model.EmployeeResponse;
import com.demo.employee.model.ProjectStatus;
import com.demo.employee.repository.EmployeeRepository;
import com.demo.employee.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private static final Logger log = LoggerFactory.getLogger(EmployeeServiceImpl.class);

	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	EmployeeActivityFeignClient employeeActivityFeignClient;

	@Override
	public EmployeeResponse createEmployee(EmployeeRequest request) {
		Employee employee = employeeRepository.findByEmailId(request.getEmailId());
		if (employee != null) {
			log.info("employee already exist with email :" + request.getEmailId());
			throw new EmployeeException("employee already exist");
		}

		employee = new Employee(new SecureRandom().nextInt(999999999), request.getName(), request.getJobTitle(),
				request.getEmailId(), request.getExperience(), request.getPhoneNumber(), request.getLocation(), "");

		employee = employeeRepository.save(employee);
		return new EmployeeResponse(employee.getCode(), employee.getName(), employee.getJobTitle(),
				employee.getEmailId(), employee.getExperience(), employee.getPhoneNumber(), employee.getLocation(),
				employee.getProjectStatus());
	}

	@Override
	public String createEmployeeWithMessage(EmployeeRequest request) {

		if (request.getName() == null || request.getName().isEmpty() || request.getName().equals("null")
				|| request.getJobTitle() == null || request.getJobTitle().isEmpty()
				|| request.getJobTitle().equals("null")) {
			throw new EmployeeException("Invalid data");
		}

		Employee employee = employeeRepository.findByEmailId(request.getEmailId());
		if (employee != null) {
			log.info("employee already exist with email :" + request.getEmailId());
			try {
				EmployeeActivityRequest employeeActivity = new EmployeeActivityRequest(employee.getName(),
						employee.getCode(), "NA", employee.getProjectStatus());
				employeeActivityFeignClient.createEmployeeActivity(employeeActivity);
			} catch (Exception e) {
				e.printStackTrace();
				log.error("employee activity not created");
			}

			throw new EmployeeException("employee already exist");
		}

		employee = new Employee(new SecureRandom().nextInt(999999999), request.getName(), request.getJobTitle(),
				request.getEmailId(), request.getExperience(), request.getPhoneNumber(), request.getLocation(), "");

		employee = employeeRepository.save(employee);
		return "Employee created with successfully with emp code : " + employee.getCode();
	}

	@Override
	public EmployeeActivityResponseList getEmployeeWithActivity(Integer code) {
		Employee employee = employeeRepository.findBycode(code);
		if (employee == null) {
			log.info("employee not found with code :" + code);
			throw new EmployeeException("employee not found");
		}

		List<EmployeeActivityResponse> res = null;

		try {
			res = employeeActivityFeignClient.getEmployeeActivity(code);
		} catch (Exception e) {
			log.error("employee activity not found");
		}

		return new EmployeeActivityResponseList(employee.getCode(), employee.getName(), employee.getJobTitle(),
				employee.getEmailId(), employee.getExperience(), employee.getPhoneNumber(), employee.getLocation(),
				employee.getProjectStatus(), res);
	}

	@Override
	public EmployeeResponse getEmployee(Integer code) {
		Employee employee = employeeRepository.findBycode(code);
		if (employee == null) {
			log.info("employee not found with code :" + code);
			throw new EmployeeException("employee not found");
		}

		return new EmployeeResponse(employee.getCode(), employee.getName(), employee.getJobTitle(),
				employee.getEmailId(), employee.getExperience(), employee.getPhoneNumber(), employee.getLocation(),
				employee.getProjectStatus());
	}

	@Override
	public EmployeeResponse updateProjectStatus(ProjectStatus projectStatus) {
		Employee employee = employeeRepository.findBycode(projectStatus.getCode());
		if (employee == null) {
			log.info("employee not found with code :" + projectStatus.getCode());
			throw new EmployeeException("employee not found");
		}
		employee.setProjectStatus(projectStatus.getProjectStatus());
		employee = employeeRepository.save(employee);

		return new EmployeeResponse(employee.getCode(), employee.getName(), employee.getJobTitle(),
				employee.getEmailId(), employee.getExperience(), employee.getPhoneNumber(), employee.getLocation(),
				employee.getProjectStatus());
	}

	@Override
	@Transactional
	public void deleteEmployee(Integer code) {
		try {
			employeeActivityFeignClient.deleteEmployee(code);
		} catch (Exception e) {
			log.error("employee activity not deleted");
		}
		employeeRepository.deleteBycode(code);
	}

	@Override
	public String getInfo() {
		// TODO Auto-generated method stub
		return null;
	}

}
