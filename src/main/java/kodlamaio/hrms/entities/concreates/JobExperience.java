package kodlamaio.hrms.entities.concreates;



import java.sql.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="job_experiences")
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class JobExperience {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	

	@ManyToOne()
	@JoinColumn(name="cv_id")
	private CurriculumVitae curriculumVitae;
	
	@ManyToOne()
	@JoinColumn(name = "job_position_id", referencedColumnName =  "id" ,nullable = false)
	private JobPosition jobPosition;
	
	@ManyToOne()
	@JoinColumn(name = "city_id", referencedColumnName =  "id" ,nullable = false)
	private City city;
	
	@Column(name="detail")
	private String detail;
	
	
	@Column(name="company_name")
	private String companyName;
	
	
	@Column(name="start_date")
	private Date startDate;
	
	@Column(name="end_date")
	private Date endDate;
	

}
