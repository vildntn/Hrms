package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concreates.CurriculumVitae;
import kodlamaio.hrms.entities.dtos.CurriculumVitaeDto;


public interface CurriculumVitaeService {
	
	Result add(CurriculumVitae curriculumVitae);
   DataResult<List<CurriculumVitae>> getAll();
   DataResult<CurriculumVitae>  getCurriculumVitaeByCandidateId(int id);
}
