package kodlamaio.hrms.business.concreates;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployerActivationByStaffService;
import kodlamaio.hrms.dataAccess.abstracts.EmployerActivationByStaffDao;
@Service
public class EmployerActivationByStaffManager implements EmployerActivationByStaffService {

	
	private EmployerActivationByStaffDao employerActivationByStaffDao;

	@Autowired
	public EmployerActivationByStaffManager(EmployerActivationByStaffDao employerActivationByStaffDao) {
		super();
		this.employerActivationByStaffDao = employerActivationByStaffDao;
	}
	
}
