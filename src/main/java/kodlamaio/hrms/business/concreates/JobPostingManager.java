package kodlamaio.hrms.business.concreates;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobPostingService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;

import kodlamaio.hrms.dataAccess.abstracts.JobPostingDao;
import kodlamaio.hrms.entities.concreates.JobPosition;
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
		return new SuccessResult("job posting added.");
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
		return new SuccessDataResult<List<JobPosting>>(jobPostingDao.getAllActiveJobPostingByEmployer(id));
	}

	@Override
	public DataResult<List<JobPosting>> getAllActiveJobPostingByDate()
	{
		Sort sort=Sort.by(Sort.Direction.DESC, "createdDate");
		return new SuccessDataResult<List<JobPosting>>(jobPostingDao.getAllActiveJobPostingByDate(sort));
	}

	@Override
	public DataResult<JobPosting> findById(int id) {
		return new SuccessDataResult<JobPosting>(jobPostingDao.findById(id));
	}

	@Override
	public Result closeJobPosting(int id) {
		if(findById(id).getData().isStatus()==false) {
			return new ErrorResult("There is no such job posting exists!");
		}
		JobPosting findByIdGetData=findById(id).getData();
		findByIdGetData.setStatus(false);
		this.jobPostingDao.save(findByIdGetData);
		return new SuccessResult("Job posting successfully closed.");
	}



	

}
