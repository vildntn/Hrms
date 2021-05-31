package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concreates.JobAdvertisement;



@RestController
@RequestMapping("/api/jobAdvertisements")
public class JobAdvertisementsController {

	private JobAdvertisementService jobAdvertisementService;

	@Autowired
	public JobAdvertisementsController(JobAdvertisementService jobAdvertisementService) {
		super();
		this.jobAdvertisementService = jobAdvertisementService;
	}
	

	@PostMapping("/add")
	public Result add(@RequestBody JobAdvertisement jobPosting){
		return jobAdvertisementService.add(jobPosting);
	}
	
	@GetMapping("/getAllActiveJobPostingByEmployer")
	public DataResult<List<JobAdvertisement>> getAllActiveJobPostingByEmployer( @RequestParam int id){
		return jobAdvertisementService.getAllActiveJobPostingByEmployer(id);
	}
	
	@GetMapping("/getall")
	public DataResult<List<JobAdvertisement>> getAll(){
		return jobAdvertisementService.getAll();
	}
	
	@GetMapping("/getActiveJobPosting")
	public DataResult<List<JobAdvertisement>> getActiveJobPosting(){
		return jobAdvertisementService.getActiveJobPosting();
	}
	
	
	@GetMapping("/getAllActiveJobPostingByDate")
	public DataResult<List<JobAdvertisement>> getAllActiveJobPostingByDate(){
		return jobAdvertisementService.getAllActiveJobPostingByDate();
	}
	
	@PostMapping("/closeJobPosting")
	public Result closeJobPosting(@RequestParam int id){
		return this.jobAdvertisementService.closeJobPosting(id);
	}

	
}
