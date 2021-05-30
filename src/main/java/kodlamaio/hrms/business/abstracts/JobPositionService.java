package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concreates.JobPosition;

public interface JobPositionService {
   DataResult<List<JobPosition>> getAll();
   List<JobPosition> getByJobTitle(String name);
   Result add(JobPosition jobPosition);
   
}
