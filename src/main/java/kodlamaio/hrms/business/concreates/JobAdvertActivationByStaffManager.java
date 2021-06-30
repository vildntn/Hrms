package kodlamaio.hrms.business.concreates;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobAdvertActivationByStaffService;
import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.business.abstracts.StaffService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobAdvertActivationByStaffDao;
import kodlamaio.hrms.entities.concreates.JobAdvertActivationByStaff;
import kodlamaio.hrms.entities.concreates.JobAdvertisement;
import kodlamaio.hrms.entities.concreates.Staff;


@Service
public class JobAdvertActivationByStaffManager implements JobAdvertActivationByStaffService {

	
	private JobAdvertActivationByStaffDao jobAdvertActivationByStaffDao;
	private JobAdvertisementService jobAdvertisementService;
	private StaffService staffService;

	
	@Autowired
	public JobAdvertActivationByStaffManager(JobAdvertActivationByStaffDao jobAdvertActivationByStaffDao,JobAdvertisementService jobAdvertisementService,
			StaffService staffService) {
		super();
		this.jobAdvertActivationByStaffDao = jobAdvertActivationByStaffDao;
		this.jobAdvertisementService=jobAdvertisementService;
		this.staffService=staffService;
	}


	@Override
	public DataResult<List<JobAdvertActivationByStaff>> getAll() {
		return new SuccessDataResult<List<JobAdvertActivationByStaff>>(jobAdvertActivationByStaffDao.findAll());
	}


	@Override
	public Result approvalJobAdvertByStaff(int jobAdvertId, int staffId) {
		JobAdvertisement jobadvert=jobAdvertisementService.findById(jobAdvertId).getData();
		Staff staff=staffService.getById(staffId).getData();
		JobAdvertActivationByStaff jobAd=new JobAdvertActivationByStaff();
		jobAd.setJobAdvertisement(jobadvert);
		jobAd.setStaff(staff);
		jobAd.setConfirmed(true);
		jobAd.setConfirmedDate(LocalDateTime.now());
		jobAdvertActivationByStaffDao.save(jobAd);
		return new SuccessResult("Job advertisement approval successful.");
	}



}




