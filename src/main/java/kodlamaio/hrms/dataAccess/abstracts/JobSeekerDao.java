package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concreates.JobSeeker;

public interface JobSeekerDao extends JpaRepository<JobSeeker, Integer> {
	//@Query("From Candidate where  user.email=:email")
	JobSeeker findByUserEmail(String email);
	List<JobSeeker> findByNationalIdentity(String nationalIdentity);

}
