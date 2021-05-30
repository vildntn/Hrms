package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concreates.JobPosting;


public interface JobPostingService {

	
	Result add(JobPosting jobPosting);
}
