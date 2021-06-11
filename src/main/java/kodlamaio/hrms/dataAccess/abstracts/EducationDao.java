package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concreates.Education;
import kodlamaio.hrms.entities.dtos.JobSeekerEducationInfoDto;


public interface EducationDao  extends JpaRepository<Education, Integer> {

	@Query("From Education  e Inner join e.curriculumVitae c Where c.jobSeeker.id=:id Order By e.graduatedDate desc ")
	List<Education> getAllEducationOrderByGraduatedDate(int id);
	
	
	//Deneme dto--çalışıyor
	@Query("Select new kodlamaio.hrms.entities.dtos.JobSeekerEducationInfoDto"
	+"(e.educationName,e.branchName,e.graduatedDate, ed.degreeName)"+
	"From CurriculumVitae c Inner Join c.jobSeeker js Inner Join c.educations e Inner Join e.educationDegree ed where js.id=:id"+
	" Order By e.graduatedDate desc")
	List<JobSeekerEducationInfoDto> getJobSeekerEducationInfoSortedGradYear(int id);
	
}
