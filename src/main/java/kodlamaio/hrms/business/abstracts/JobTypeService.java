package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concreates.JobType;


public interface JobTypeService {

	
	DataResult<List<JobType>> getAll();
	Result add(JobType jobType);
}
