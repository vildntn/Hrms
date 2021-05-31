package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobPostingService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concreates.JobPosting;



@RestController
@RequestMapping("/api/jobPosting")
public class JobPostingController {

	private JobPostingService jobPostingService;

	@Autowired
	public JobPostingController(JobPostingService jobPostingService) {
		super();
		this.jobPostingService = jobPostingService;
	}
	

	@PostMapping("/add")
	public Result add(@RequestBody JobPosting jobPosting){
		return jobPostingService.add(jobPosting);
	}
	
	@GetMapping("/getAllActiveJobPostingByEmployer")
	public DataResult<List<JobPosting>> getAllActiveJobPostingByEmployer( @RequestParam int id){
		return jobPostingService.getAllActiveJobPostingByEmployer(id);
	}
	
	@GetMapping("/getall")
	public DataResult<List<JobPosting>> getAll(){
		return jobPostingService.getAll();
	}
	
	@GetMapping("/getActiveJobPosting")
	public DataResult<List<JobPosting>> getActiveJobPosting(){
		return jobPostingService.getActiveJobPosting();
	}
	
	
	@GetMapping("/getAllActiveJobPostingByDate")
	public DataResult<List<JobPosting>> getAllActiveJobPostingByDate(){
		return jobPostingService.getAllActiveJobPostingByDate();
	}
	
	@PostMapping("/closeJobPosting")
	public Result closeJobPosting(@RequestParam int id){
		return this.jobPostingService.closeJobPosting(id);
	}

	
}
