package kodlamaio.hrms.business.concreates;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EducationService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EducationDao;
import kodlamaio.hrms.entities.concreates.Education;
import kodlamaio.hrms.entities.dtos.CandidateEducationInfoSortedGradYearDto;
@Service
public class EducationManager implements EducationService{

	
private EducationDao educationDao;
	
	
	@Autowired
	public EducationManager(EducationDao educationDao) {
	super();
	this.educationDao = educationDao;
}



	@Override
	public Result add(Education education) {
		educationDao.save(education);
		return new SuccessResult("Eğitim eklendi");
	}



	@Override
	public DataResult<List<Education>> getAll() {
		return new SuccessDataResult<List<Education>>(educationDao.findAll());
	}



	@Override
	public DataResult<List<CandidateEducationInfoSortedGradYearDto>> getCandidateEducationInfoSortedGradYear(int id) {
		return new SuccessDataResult<List<CandidateEducationInfoSortedGradYearDto>>(educationDao.getCandidateEducationInfoSortedGradYear(id));
	}

}
