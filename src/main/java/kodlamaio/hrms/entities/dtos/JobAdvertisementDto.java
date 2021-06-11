package kodlamaio.hrms.entities.dtos;

import java.time.LocalDate;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertisementDto {

	private int id;
	private String jobTitle;
	
	private String companyName;
	private String cityName;
	private int minSalary;
	private int maxSalary;
	private int openPosition;
	private LocalDate applicationDeadline;
	
}
