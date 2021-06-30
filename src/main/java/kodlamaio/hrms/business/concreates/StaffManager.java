package kodlamaio.hrms.business.concreates;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.StaffService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.StaffDao;
import kodlamaio.hrms.entities.concreates.Staff;

@Service
public class StaffManager implements StaffService {
	
	private StaffDao staffDao;

	@Autowired
	public StaffManager(StaffDao staffDao) {
		super();
		this.staffDao = staffDao;
	}

	@Override
	public DataResult<List<Staff>> getAll() {
		return new SuccessDataResult<List<Staff>>(staffDao.findAll(),"Tüm liste listelendi");
	}

	@Override
	public Result add(Staff staff) {
		staffDao.save(staff);
		return new SuccessResult("New Staff Added!");
	}

	@Override
	public DataResult<Staff> getById(int staffId) {
		return new SuccessDataResult<Staff>(staffDao.getOne(staffId));

	}

}
