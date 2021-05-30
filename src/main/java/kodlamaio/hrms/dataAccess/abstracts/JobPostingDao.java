package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concreates.JobPosting;

public interface JobPostingDao extends JpaRepository<JobPosting, Integer>{

	@Query("From JobPosting where status=true")
	List<JobPosting> getActiveJobPosting();
	
	@Query("From JobPosting where id=:id")
	List<JobPosting> getAllActiveJobPostingByEmployer(int id);
	
}
