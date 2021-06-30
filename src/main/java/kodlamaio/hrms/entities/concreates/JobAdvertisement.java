package kodlamaio.hrms.entities.concreates;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name="job_advertisement")
@AllArgsConstructor
@NoArgsConstructor

public class JobAdvertisement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@ManyToOne(targetEntity = Employer.class , optional = false)
	@JoinColumn(name = "employer_id", referencedColumnName =  "id" ,nullable = false)
	//@ManyToOne
//	@JoinColumn(name="employer_id")
	private Employer employer;
	
	@ManyToOne(targetEntity = JobPosition.class , optional = false)
	@JoinColumn(name="job_position_id")
	private JobPosition  jobPosition;
	
	@ManyToOne(targetEntity = City.class)
	@JoinColumn(name="city_id")
	private City city;
	
	@Column(name="job_description")
	private String jobDescription;
	
	@Column(name="open_position")
	private int openPosition;
	
	@Column(name="max_salary")
	private int maxSalary;
	
	@Column(name="min_salary")
	private int minSalary;
	
	@Column(name="application_deadline")
	private LocalDate applicationDeadline;
	
	@Column(name="status")
	private boolean status;
	
	@Column(name="created_date")
	private Date createdDate;
	
	@Column(name="is_confirmed")
	private boolean isConfirmed;
	
	@ManyToOne
	@JoinColumn(name="work_type_id")
	private WorkType workType;
	
	@ManyToOne
	@JoinColumn(name="job_type_id")
	private JobType jobType;



	
}
