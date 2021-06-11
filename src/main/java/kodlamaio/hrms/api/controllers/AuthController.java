package kodlamaio.hrms.api.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.AuthService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concreates.JobSeeker;
import kodlamaio.hrms.entities.concreates.Employer;


@RestController
@RequestMapping("/api/auth")
public class AuthController {

	private AuthService authService;

	@Autowired
	public AuthController(AuthService authService) {
		super();
		this.authService = authService;
		
	}
	
	@PostMapping("/registerbycandidate")
	public Result register(@RequestBody JobSeeker jobSeeker, String rePassword){
		return authService.registerByJobSeeker(jobSeeker, rePassword);
	}
	
	@PostMapping("/registerbyemployer")
	public Result register(@RequestBody Employer employer, String rePassword){
		return authService.registerByEmployer(employer, rePassword);
	}
}	
	
