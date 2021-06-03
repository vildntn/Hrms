package kodlamaio.hrms.entities.dtos;

import java.util.List;

import kodlamaio.hrms.entities.concreates.Education;
import kodlamaio.hrms.entities.concreates.JobExperience;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CurriculumVitaeDto {
	//Devamı gelicek inş
	private List<Education> educations;
	private List<JobExperience> jobExperiences;
	
}
