package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concreates.EmployerActivationByStaff;

public interface EmployerActivationByStaffService {

	Result approvalEmployerByStaff(EmployerActivationByStaff employerActivationByStaff);
}
