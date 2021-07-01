package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concreates.Staff;


public interface StaffService {
	DataResult<List<Staff>> getAll();
	Result add(Staff staff);
	DataResult<Staff> getById(int staffId);
	Result update(Staff staff);
}
