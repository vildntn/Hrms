package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobExperinceService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concreates.JobExperience;
import kodlamaio.hrms.entities.dtos.CandidateJobExperienceInfoSortedByDate;

@RestController
@RequestMapping("/api/jobExperience")
public class JobExperiencesController {
	private JobExperinceService jobExperienceService;

	@Autowired
	public JobExperiencesController(JobExperinceService jobExperienceService) {
		super();
		this.jobExperienceService = jobExperienceService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody JobExperience jobExperience){
		return jobExperienceService.add(jobExperience);
	}

	@GetMapping("/getCandidateJobExperienceInfoSortedByDate")
	public DataResult<List<CandidateJobExperienceInfoSortedByDate>> getCandidateJobExperienceInfoSortedByDate(int id){
		return this.jobExperienceService.getCandidateJobExperienceInfoSortedByDate(id);
		}
}
