package kodlamaio.hrms.business.concreates;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.entities.concreates.Employer;

@Service
public class EmployerManager implements EmployerService{
	
	private EmployerDao employerDao;

	@Autowired
	public EmployerManager(EmployerDao employerDao) {
		super();
		this.employerDao = employerDao;
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(employerDao.findAll(),"Tüm liste listelendi");
		
	}

	@Override
	public Result add(Employer employer) {
		employerDao.save(employer);
		return new SuccessResult("New Employer Added!");
	}

	@Override
	public DataResult<Employer> getByEmail(String email) {
		return new SuccessDataResult<Employer>(employerDao.findByUserEmail(email));
		
	}

	@Override
	public DataResult<Employer> getbyWebAddress(String webAddress) {
		return new SuccessDataResult<Employer>(employerDao.findByWebAddress(webAddress));
	}

	@Override
	public Result update(Employer employer) {
		Employer updatedEmployer=employerDao.getOne(employer.getId());
		updatedEmployer=employer;
		employerDao.save(updatedEmployer);
		
		return new SuccessResult("employer updated");
	}

	@Override
	public Result delete(Employer employer) {
		employerDao.delete(employer);
		return new SuccessResult(employer.getCompanyName()+"  Successfuly deleted");
	}

	@Override
	public DataResult<Employer> getById(int id) {
		return new SuccessDataResult<Employer>(employerDao.getOne(id));
	}

}
