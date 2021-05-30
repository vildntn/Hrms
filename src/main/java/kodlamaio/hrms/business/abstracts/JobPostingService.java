package kodlamaio.hrms.business.abstracts;

import java.util.List;



import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concreates.JobPosting;


public interface JobPostingService {

	
	Result add(JobPosting jobPosting);
	DataResult<List<JobPosting>> getAll();
	DataResult<List<JobPosting>> getActiveJobPosting();
	DataResult<List<JobPosting>> getAllActiveJobPostingByEmployer(int id);
	DataResult<List<JobPosting>> getAllActiveJobPostingByDate();

}
