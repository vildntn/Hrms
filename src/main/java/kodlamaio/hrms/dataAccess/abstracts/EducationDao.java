package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concreates.Education;
import kodlamaio.hrms.entities.dtos.CandidateEducationInfoDto;


public interface EducationDao  extends JpaRepository<Education, Integer> {

	@Query("From Education  e Inner join e.curriculumVitae c Where c.candidate.id=:id Order By e.graduatedDate desc ")
	List<Education> getAllEducationOrderByGraduatedDate(int id);
	
	
	//Deneme dto--çalışıyor
	@Query("Select new kodlamaio.hrms.entities.dtos.CandidateEducationInfoDto"
	+"(ca.firstName,ca.lastName,e.educationName,e.branchName,e.graduatedDate, ed.degreeName, ed.id, c.id,e.id)"+
	"From CurriculumVitae c Inner Join c.candidate ca Inner Join c.educations e Inner Join e.educationDegree ed where ca.id=:id"+
	" Order By e.graduatedDate desc")
	List<CandidateEducationInfoDto> getCandidateEducationInfoSortedGradYear(int id);
	
}
