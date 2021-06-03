package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concreates.CurriculumVitae;
import kodlamaio.hrms.entities.dtos.CurriculumVitaeDto;





public interface CurriculumVitaeDao  extends JpaRepository<CurriculumVitae, Integer> {

	
//deneme dto silindi
	
//	 @Query("Select new kodlamaio.hrms.entities.dtos.CvDto"
//		  		+ "(c.candidate.id, e.branchName, e.educationName, c.githubUrl, j.companyName) "
//		  		+ "From CurriculumVitae c Inner Join c.educations e Inner Join c.jobExperiences j")
//		  List<CvDto> getCv();
	
	
//	 @Query("Select new kodlamaio.hrms.entities.dtos.CurriculumVitaeDto"
//		  		+ "(c.educations, c.jobExperiences) "
//		  		+ "From CurriculumVitae c Inner Join c.educations e Inner Join c.jobExperiences j  Where c.candidate.id=:id")
//	List<CurriculumVitaeDto> getCurriculumVitaeDto(int id);
	 
	 
}
