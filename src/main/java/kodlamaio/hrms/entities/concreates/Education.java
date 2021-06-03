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
@Table(name="educations")
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Education {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@ManyToOne()
	@JoinColumn(name="cv_id")

	private CurriculumVitae curriculumVitae;
	
	@ManyToOne()
	@JoinColumn(name="education_degree_id")
	private EducationDegree educationDegree;
	
	@Column(name="education_name")
	private String educationName;
		
	@Column(name="branch_name")
	private String branchName;
	
	@Column(name="start_date")
	private Date  startedDate;
	
	@Column(name="graduated_date")
	private Date graduatedDate;

}
