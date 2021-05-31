package kodlamaio.hrms.business.abstracts;

import java.util.List;



import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concreates.JobAdvertisement;


public interface JobAdvertisementService {

	
	Result add(JobAdvertisement jobPosting);
	DataResult<List<JobAdvertisement>> getAll();
	DataResult<List<JobAdvertisement>> getActiveJobPosting();
	DataResult<List<JobAdvertisement>> getAllActiveJobPostingByEmployer(int id);
	DataResult<List<JobAdvertisement>> getAllActiveJobPostingByDate();
	
	DataResult<JobAdvertisement> findById(int id);
	
	Result closeJobPosting(int id);

}
