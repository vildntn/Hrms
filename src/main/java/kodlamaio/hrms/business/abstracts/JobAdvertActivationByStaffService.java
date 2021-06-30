package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concreates.JobAdvertActivationByStaff;

public interface JobAdvertActivationByStaffService {

	 
	DataResult<List<JobAdvertActivationByStaff>> getAll();
   Result approvalJobAdvertByStaff(int jobAdvertId, int staffId );
}
