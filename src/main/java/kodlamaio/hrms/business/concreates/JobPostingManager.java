package kodlamaio.hrms.business.concreates;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobPostingService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;

import kodlamaio.hrms.dataAccess.abstracts.JobPostingDao;
import kodlamaio.hrms.entities.concreates.JobPosting;
@Service
public class JobPostingManager implements JobPostingService {
	
	private JobPostingDao jobPostingDao;

	@Autowired
	public JobPostingManager(JobPostingDao jobPostingDao) {
		super();
		this.jobPostingDao = jobPostingDao;
	}

	@Override
	public Result add(JobPosting jobPosting) {
		jobPostingDao.save(jobPosting);
		return new SuccessResult("iş ilanı eklendi");
	}

	@Override
	public DataResult<List<JobPosting>> getAll() {
		return new SuccessDataResult<List<JobPosting>>(jobPostingDao.findAll());
	}

	@Override
	public DataResult<List<JobPosting>> getActiveJobPosting() {
		return new SuccessDataResult<List<JobPosting>>(jobPostingDao.getActiveJobPosting());
	}

	@Override
	public DataResult<List<JobPosting>> getAllActiveJobPostingByEmployer(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<List<JobPosting>> getAllActiveJobPostingByDate() {
		// TODO Auto-generated method stub
		return null;
	}

}
