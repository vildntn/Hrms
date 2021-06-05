package kodlamaio.hrms.entities.dtos;




import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CandidateEducationInfoDto {

	
	private String firstName;
	private String lastName;
	
	private String educationName;
	private String branchName;
	private Date graduatedDate;
	
	private String degreeName;
	
	private int degreeId;
	private int cvId;
	private int educationId;
	
}
