package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concreates.Candidate;

public interface CandidateDao extends JpaRepository<Candidate, Integer> {
	//@Query("From Candidate where  user.email=:email")
	Candidate findByEmail(String email);
	List<Candidate> findByNationalIdentity(String nationalIdentity);

}
