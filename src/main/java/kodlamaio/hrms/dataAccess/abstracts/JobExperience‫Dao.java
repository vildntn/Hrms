package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concreates.JobExperience;
import kodlamaio.hrms.entities.dtos.JobSeekerJobExperienceInfoDto;



public interface JobExperience‫Dao  extends JpaRepository<JobExperience, Integer> {
	
	@Query("From JobExperience j Inner join j.curriculumVitae c Where c.jobSeeker.id=:id Order By j.endDate desc")
	List<JobExperience> getAllJobExperienceByCandidateIdByDate(int id);
	
	//Deneme dto--çalışıyor
	@Query("Select new kodlamaio.hrms.entities.dtos.JobSeekerJobExperienceInfoDto"
			+"(jb.jobTitle,j.companyName,j.startDate,j.endDate)"+
			"From CurriculumVitae c Inner Join c.jobExperiences j Inner Join j.jobPosition jb where c.jobSeeker.id=:id"+
			" Order By j.endDate desc")
			List<JobSeekerJobExperienceInfoDto> getJobSeekerJobExperienceInfoSortedByDate(int id);

}
