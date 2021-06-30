package kodlamaio.hrms.business.abstracts;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concreates.CurriculumVitae;



public interface CurriculumVitaeService {
	
   Result add(CurriculumVitae curriculumVitae);
   DataResult<List<CurriculumVitae>> getAll();
   DataResult<CurriculumVitae>  getCurriculumVitaeByCandidateId(int id);
  // Result addPhoto(MultipartFile file, int cvId) throws IOException;
   Result delete(CurriculumVitae curriculumVitae);
   Result update(CurriculumVitae curriculumVitae);
}
