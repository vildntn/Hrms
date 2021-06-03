package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concreates.JobExperience;
import kodlamaio.hrms.entities.dtos.CandidateJobExperienceInfoSortedByDate;



public interface JobExperience‫Dao  extends JpaRepository<JobExperience, Integer> {
	
	@Query("Select new kodlamaio.hrms.entities.dtos.CandidateJobExperienceInfoSortedByDate"
			+"(jb.jobTitle,j.companyName,j.startDate,j.endDate)"+
			"From CurriculumVitae c Inner Join c.jobExperiences j Inner Join j.jobPosition jb where c.candidate.id=:id"+
			" Order By j.endDate desc")
			List<CandidateJobExperienceInfoSortedByDate> getCandidateJobExperienceInfoSortedByDate(int id);

}
