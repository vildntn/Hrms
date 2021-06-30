package kodlamaio.hrms.business.concreates;

import java.io.IOException;
import java.util.List;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.business.abstracts.CurriculumVitaeService;
import kodlamaio.hrms.business.abstracts.EducationService;
import kodlamaio.hrms.business.abstracts.JobExperinceService;
import kodlamaio.hrms.core.utilities.adapters.CloudinaryService;
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
	private CloudinaryService cloudinaryService;
	
	
	@Autowired
	public CurriculumVitaeManager(CurriculumVitaeDao curriculumVitaeDao,EducationService educationService,
			JobExperinceService jobExperienceService,CloudinaryService cloudinaryService
			) {
		super();
		this.curriculumVitaeDao = curriculumVitaeDao;
		this.educationService=educationService;
		this.jobExperienceService=jobExperienceService;
		this.cloudinaryService=cloudinaryService;
	
	}
	@Override
	public Result add(CurriculumVitae curriculumVitae) {
		curriculumVitaeDao.save(curriculumVitae);
		return new SuccessResult("Cv added");
	}
	@Override
	public DataResult<List<CurriculumVitae>> getAll() {
		return new SuccessDataResult<List<CurriculumVitae>>(curriculumVitaeDao.findAll());
	}
	@Override
	public DataResult<CurriculumVitae> getCurriculumVitaeByCandidateId(int id) {
	    return new SuccessDataResult<CurriculumVitae>(curriculumVitaeDao.getCurriculumVitaeByCandidateId(id));
	}
//	@Override
//	public Result addPhoto(MultipartFile file, int cvId) throws IOException {
//		Map map = cloudinaryService.upload(file);
//		String photoUrl=map.get("url").toString();
//		CurriculumVitae cv=curriculumVitaeDao.getOne(cvId);
//		cv.setPhotoUrl(photoUrl);
//		curriculumVitaeDao.save(cv);
//		return new SuccessResult("Photo added");
//	}
	@Override
	public Result delete(CurriculumVitae curriculumVitae) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Result update(CurriculumVitae curriculumVitae) {
		// TODO Auto-generated method stub
		return null;
	}


}
