package kodlamaio.hrms.business.concreates;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobSeekerService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobSeekerDao;
import kodlamaio.hrms.entities.concreates.JobSeeker;

@Service
public class JobSeekerManager implements JobSeekerService {
	
	private JobSeekerDao jobSeekerDao;

	@Autowired
	public JobSeekerManager(JobSeekerDao jobSeekerDao) {
		super();
		this.jobSeekerDao = jobSeekerDao;
	}

	@Override
	public DataResult<List<JobSeeker>> getAll() {
		
		return new SuccessDataResult<List<JobSeeker>>(jobSeekerDao.findAll(),"The entire list is listed. ");
	}

	@Override
	public Result add(JobSeeker jobSeeker) {
		jobSeekerDao.save(jobSeeker);
		return new SuccessResult("Added");
	}

	@Override
	public DataResult<JobSeeker> getByMail(String email) {
		return new SuccessDataResult<JobSeeker>(jobSeekerDao.findByUserEmail(email));
	}

	@Override
	public DataResult<List<JobSeeker>> getByNationalIdentity(String nationalIdentity) {
		return new SuccessDataResult<List<JobSeeker>>(jobSeekerDao.findByNationalIdentity(nationalIdentity));
	}
	
	
	
	

}
