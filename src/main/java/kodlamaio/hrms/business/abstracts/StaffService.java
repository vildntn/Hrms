package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concreates.Staff;
import kodlamaio.hrms.entities.dtos.StaffDto;


public interface StaffService {
	DataResult<List<Staff>> getAll();
	Result add(Staff staff);
	DataResult<Staff> getById(int staffId);
	Result update(StaffDto staffDto);
	Result delete(Staff staff);
	DataResult<Staff> getByEmail(String email);

}
