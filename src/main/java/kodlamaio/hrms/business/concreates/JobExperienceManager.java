package kodlamaio.hrms.business.concreates;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobExperinceService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobExperience‫Dao;
import kodlamaio.hrms.entities.concreates.JobExperience;
import kodlamaio.hrms.entities.dtos.CandidateJobExperienceInfoSortedByDate;
@Service
public class JobExperienceManager implements JobExperinceService {

	private JobExperience‫Dao jobExperienceDao;
	
	@Autowired
	public JobExperienceManager(JobExperience‫Dao jobExperienceDao) {
		super();
		this.jobExperienceDao = jobExperienceDao;
	}

	@Override
	public Result add(JobExperience jobExperience) {
		jobExperienceDao.save(jobExperience);
		return new SuccessResult("İş deneyimi eklendi");
	}

	@Override
	public DataResult<List<CandidateJobExperienceInfoSortedByDate>> getCandidateJobExperienceInfoSortedByDate(int id) {
		return new SuccessDataResult<List<CandidateJobExperienceInfoSortedByDate>>(jobExperienceDao.getCandidateJobExperienceInfoSortedByDate(id));
	}

}
