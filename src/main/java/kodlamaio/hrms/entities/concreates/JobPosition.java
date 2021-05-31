package kodlamaio.hrms.entities.concreates;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
@Data
@Entity
@Table(name="job_positions")
@JsonIgnoreProperties(ignoreUnknown = true, 
value = {"hibernateLazyInitializer", "handler","jobPostings"})
 public class JobPosition {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="id")
  private int id;
 
  @Column(name="job_title")
  private String jobTitle;
 
  @OneToMany(mappedBy = "jobPosition")

	private List<JobPosting> jobPostings;
 
 public JobPosition() {
	 
 }

public JobPosition(int id, String jobTitle) {
	super();
	this.id = id;
	this.jobTitle = jobTitle;
}
}
