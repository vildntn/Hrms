package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.EducationService;
import kodlamaio.hrms.business.abstracts.EmployerActivationByStaffService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concreates.Education;
import kodlamaio.hrms.entities.concreates.EmployerActivationByStaff;

@RestController
@RequestMapping("/api/employerActivationByStaff")
@CrossOrigin
public class EmployerActivationByStaffController {


	private EmployerActivationByStaffService employerActivationByStaffService;

	@Autowired
	public EmployerActivationByStaffController( EmployerActivationByStaffService employerActivationByStaffService) {
		super();
		this.employerActivationByStaffService = employerActivationByStaffService;
	}

	@PostMapping("/approvalEmployerByStaff")
	public Result approvalEmployerByStaff( @RequestBody EmployerActivationByStaff employerActivationByStaff){
		return employerActivationByStaffService.approvalEmployerByStaff(employerActivationByStaff);
	}
	

}
