package kodlamaio.hrms.business.concreates;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CurriculumVitaeService;
import kodlamaio.hrms.business.abstracts.EducationService;
import kodlamaio.hrms.business.abstracts.JobExperinceService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CurriculumVitaeDao;
import kodlamaio.hrms.entities.concreates.CurriculumVitae;
import kodlamaio.hrms.entities.dtos.CurriculumVitaeDto;

@Service
public class CurriculumVitaeManager implements CurriculumVitaeService{

	private CurriculumVitaeDao curriculumVitaeDao;
	private EducationService educationService;
	private JobExperinceService jobExperienceService;
	
	
	@Autowired
	public CurriculumVitaeManager(CurriculumVitaeDao curriculumVitaeDao,EducationService educationService,
			JobExperinceService jobExperienceService
			) {
		super();
		this.curriculumVitaeDao = curriculumVitaeDao;
		this.educationService=educationService;
		this.jobExperienceService=jobExperienceService;
	
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
	@Override
	public DataResult<CurriculumVitae> getCurriculumVitaeByCandidateId(int id) {
	    return new SuccessDataResult<CurriculumVitae>(curriculumVitaeDao.getCurriculumVitaeByCandidateId(id));
	}


}
