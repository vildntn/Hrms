package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concreates.JobPosting;

public interface JobPostingDao extends JpaRepository<JobPosting, Integer>{

}
