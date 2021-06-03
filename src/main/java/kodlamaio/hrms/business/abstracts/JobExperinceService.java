package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concreates.JobExperience;


public interface JobExperinceService {

	Result add(JobExperience jobExperience);
	DataResult<List<JobExperience>> getAllJobExperienceByCandidateIdByDate(int id);
}
