package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concreates.JobSeeker;

public interface JobSeekerService {

	
	DataResult<List<JobSeeker>> getAll();
	Result add(JobSeeker jobSeeker);
	DataResult<JobSeeker> getByMail(String email);
	DataResult<List<JobSeeker>> getByNationalIdentity(String nationalIdentity);
}
