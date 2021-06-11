package kodlamaio.hrms.entities.dtos;

import java.util.Date;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data

@AllArgsConstructor
@NoArgsConstructor
public class JobSeekerJobExperienceInfoDto {

	private String positionName;
	private String companyName;
	private Date startDate;
	private Date endDate;
	
}
