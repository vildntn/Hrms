package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concreates.JobType;

public interface JobTypeDao  extends JpaRepository<JobType, Integer>{

}
