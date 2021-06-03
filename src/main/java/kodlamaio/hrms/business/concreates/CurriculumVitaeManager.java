package kodlamaio.hrms.business.concreates;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CurriculumVitaeService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CurriculumVitaeDao;
import kodlamaio.hrms.entities.concreates.CurriculumVitae;

@Service
public class CurriculumVitaeManager implements CurriculumVitaeService{

	private CurriculumVitaeDao curriculumVitaeDao;
	
	@Autowired
	public CurriculumVitaeManager(CurriculumVitaeDao curriculumVitaeDao) {
		super();
		this.curriculumVitaeDao = curriculumVitaeDao;
	}
	@Override
	public Result add(CurriculumVitae curriculumVitae) {
		curriculumVitaeDao.save(curriculumVitae);
		return new SuccessResult("Eklendi");
	}
	@Override
	public DataResult<List<CurriculumVitae>> getAll() {
		return new SuccessDataResult<List<CurriculumVitae>>(curriculumVitaeDao.findAll());
	}
//	@Override
//	public DataResult<List<CurriculumVitae>> getById(int id) {
//	     re
//	}

}
