package kodlamaio.hrms.entities.concreates;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table(name="job_positions")
public class JobPosition {
 @Id
 @GeneratedValue
 @Column(name="id")
 private int id;
 
 @Column(name="job_title")
 private String jobTitle;
 
 public JobPosition() {
	 
 }

public JobPosition(int id, String jobTitle) {
	super();
	this.id = id;
	this.jobTitle = jobTitle;
}
}
