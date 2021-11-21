package kodlamaio.hrms.business.concreates;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployerActivationByStaffService;
import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.business.abstracts.StaffService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployerActivationByStaffDao;
import kodlamaio.hrms.entities.concreates.Employer;
import kodlamaio.hrms.entities.concreates.EmployerActivationByStaff;
import kodlamaio.hrms.entities.concreates.Staff;
@Service
public class EmployerActivationByStaffManager implements EmployerActivationByStaffService {

	
	private EmployerActivationByStaffDao employerActivationByStaffDao;
	private EmployerService employerService;
	private StaffService staffService;

	@Autowired
	public EmployerActivationByStaffManager(EmployerActivationByStaffDao employerActivationByStaffDao,EmployerService employerService,
			StaffService staffService) {
		super();
		this.employerActivationByStaffDao = employerActivationByStaffDao;
		this.employerService=employerService;
		this.staffService=staffService;
	}

	@Override
	public Result approvalEmployerByStaff( EmployerActivationByStaff employerActivationByStaff) {
//		Employer employer=employerService.getById(employerId).getData();
//		Staff staff=staffService.getById(staffId).getData();
//		employerActivationByStaff.setEmployer(employer);
//		employerActivationByStaff.setStaff(staff);
//		employerActivationByStaff.setStatus(true);
//		employerActivationByStaff.setConfirmedDate(LocalDateTime.now());
		employerActivationByStaffDao.save(employerActivationByStaff);
		return new SuccessResult("onaylama başarılı");
	}
	
}
