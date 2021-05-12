package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.entities.concreates.JobPosition;

public interface JobPositionService {
   List<JobPosition> getAll();
}
