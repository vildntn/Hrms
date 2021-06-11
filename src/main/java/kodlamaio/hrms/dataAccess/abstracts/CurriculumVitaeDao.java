package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concreates.CurriculumVitae;






public interface CurriculumVitaeDao  extends JpaRepository<CurriculumVitae, Integer> {

	@Query("From CurriculumVitae c Where c.jobSeeker.id=:id")
	CurriculumVitae getCurriculumVitaeByCandidateId(int id);

	
	

	 
	 
}
