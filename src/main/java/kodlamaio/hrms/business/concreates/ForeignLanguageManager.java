package kodlamaio.hrms.business.concreates;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.ForeignLanguageService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
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
		foreignLanguageDao.delete(foreignLanguage);
		return new SuccessResult("Foreign language deleted");
	}

	
	@Override
	public Result update(ForeignLanguage foreignLanguage) {
		ForeignLanguage forLang=foreignLanguageDao.getOne(foreignLanguage.getId());
		forLang.setLanguageLevel(foreignLanguage.getLanguageLevel());
		forLang.setLanguageName(foreignLanguage.getLanguageName());
		forLang.setCurriculumVitae(foreignLanguage.getCurriculumVitae());
		return null;
	}


	@Override
	public DataResult<List<ForeignLanguage>> getAll() {
		//hata veriyor
		return new SuccessDataResult<List<ForeignLanguage>>(foreignLanguageDao.findAll());
	}


	@Override
	public DataResult<ForeignLanguage> getById(int id) {
		//getone da da patlıyor neden?
		//hata veriyor
		return new SuccessDataResult<ForeignLanguage>(foreignLanguageDao.findById(id).get());
	}

}
