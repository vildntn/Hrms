package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concreates.JobAdvertisement;
import kodlamaio.hrms.entities.dtos.JobAdvertisementDto;


public interface JobAdvertisementService {

	
	Result add(JobAdvertisement jobPosting);
	DataResult<List<JobAdvertisement>> getAll();
	DataResult<List<JobAdvertisement>> getActiveJobAdvertisement();
	DataResult<List<JobAdvertisement>> getAllActiveJobAdvertisementByEmployer(int id);
	DataResult<List<JobAdvertisement>> getAllActiveJobAdvertisementByDate();
	DataResult<List<JobAdvertisementDto>> getAllActiveJobAdvertisement();
	
	DataResult<JobAdvertisement> findById(int id);
	
	Result closeJobPosting(int id);

}
