package kodlamaio.hrms.entities.concreates;


import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="curriculum_vitaes")
@NoArgsConstructor
@AllArgsConstructor
//@JsonIgnoreProperties({"hibernateLazyInitializer","handler","foreignLanguages","programOrTechnologyLanguages","educations","jobExperiences"})
public class CurriculumVitae {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@ManyToOne()
	@JoinColumn(name = "job_seeker_id", referencedColumnName =  "id" ,nullable = false)
	private JobSeeker jobSeeker;
	
	
	@Column(name="github_url")
	private String githubUrl;
	
	@Column(name="linkedin_url")
	private String linkedinUrl;
	
//	@Column(name="photo_url")
//	private String photoUrl;
	
	@Column(name="describe")
	private String describe;
	
	@Column(name="created_date")
	private LocalDate createdDate;
	
	@Column(name="status")
	private boolean status;
	
	
	 @OneToMany(mappedBy = "curriculumVitae" ) 
	 private List<ForeignLanguage> foreignLanguages;
	  
	 @OneToMany(mappedBy = "curriculumVitae" )
	 private List<ProgramOrTechnologyLanguage> programOrTechnologyLanguages;
	  

	 @OneToMany(mappedBy = "curriculumVitae" ) 
	 private List<Education> educations;
	 
	 @OneToMany(mappedBy = "curriculumVitae" )
	 private List<JobExperience> jobExperiences;	 
	
}
