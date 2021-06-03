package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concreates.Education;
import kodlamaio.hrms.entities.dtos.CandidateEducationInfoSortedGradYearDto;

public interface EducationService {

	
	Result add(Education education);
	DataResult<List<Education>> getAll();
    DataResult<List<CandidateEducationInfoSortedGradYearDto>> getCandidateEducationInfoSortedGradYear(int id);
}
