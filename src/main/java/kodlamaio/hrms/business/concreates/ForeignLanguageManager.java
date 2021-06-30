package kodlamaio.hrms.business.concreates;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.ForeignLanguageService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.ForeignLanguageDao;
import kodlamaio.hrms.entities.concreates.ForeignLanguage;
@Service
public class ForeignLanguageManager implements ForeignLanguageService {

	
	private ForeignLanguageDao foreignLanguageDao;
	
	@Autowired
	public ForeignLanguageManager(ForeignLanguageDao foreignLanguageDao) {
		super();
		this.foreignLanguageDao = foreignLanguageDao;
	}

	
	@Override
	public Result add(ForeignLanguage foreignLanguage) {
		foreignLanguageDao.save(foreignLanguage);
		return new SuccessResult("New Foreign Language added!");
	}

	
	@Override
	public Result delete(ForeignLanguage foreignLanguage) {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public Result update(ForeignLanguage foreignLanguage) {
		// TODO Auto-generated method stub
		return null;
	}

}
