package kodlamaio.hrms.business.concreates;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobAdvertisementDao;
import kodlamaio.hrms.entities.concreates.JobAdvertisement;
import kodlamaio.hrms.entities.concreates.JobPosition;
import kodlamaio.hrms.entities.dtos.JobAdvertisementDto;
@Service
public class JobAdvertisementManager implements JobAdvertisementService {
	
	private JobAdvertisementDao jobAdvertisementDao;


	@Autowired
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao) {
		super();
		this.jobAdvertisementDao = jobAdvertisementDao;

		
	}

	@Override
	public Result add(JobAdvertisement jobAdvert) {
		jobAdvertisementDao.save(jobAdvert);
		return new SuccessResult("Job advertisement added.");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAll() {
		return new SuccessDataResult<List<JobAdvertisement>>(jobAdvertisementDao.findAll());
	}

	@Override
	public DataResult<List<JobAdvertisement>> getActiveJobAdvertisement() {
		return new SuccessDataResult<List<JobAdvertisement>>(jobAdvertisementDao.getActiveJobAdvertisement());
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAllActiveJobAdvertisementByEmployer(int id) {
		return new SuccessDataResult<List<JobAdvertisement>>(jobAdvertisementDao.getAllActiveJobAdvertisementByEmployer(id));
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAllActiveJobAdvertisementByDate()
	{
		Sort sort=Sort.by(Sort.Direction.DESC, "createdDate");
		return new SuccessDataResult<List<JobAdvertisement>>(jobAdvertisementDao.getAllActiveJobAdvertisementByDate(sort));
	}

	@Override
	public DataResult<JobAdvertisement> findById(int id) {
		return new SuccessDataResult<JobAdvertisement>(jobAdvertisementDao.findById(id));
	}

	@Override
	public Result closeJobAdvert(int id) {
		if(findById(id).getData().isStatus()==false) {
			return new ErrorResult("There is no such job advertisement exists!");
		}
		JobAdvertisement findByIdGetData=findById(id).getData();
		findByIdGetData.setStatus(false);
		this.jobAdvertisementDao.save(findByIdGetData);
		return new SuccessResult("Job advertisement successfully closed.");
	}
	

	@Override
	public DataResult<List<JobAdvertisementDto>> getAllActiveJobAdvertisement() {
		return new SuccessDataResult<List<JobAdvertisementDto>>(jobAdvertisementDao.getAllActiveJobAdvertisement());
	}

	@Override
	public Result isJobAdvertConfirmed(int id) {

		JobAdvertisement findByIdGetData=findById(id).getData();
		if(findByIdGetData.isConfirmed()) {
			return new SuccessResult("Already approved!");
		}
		findByIdGetData.setConfirmed(true);
		this.jobAdvertisementDao.save(findByIdGetData);
		return new SuccessResult("Job posting successfully confirmed.");
	}



	

}
