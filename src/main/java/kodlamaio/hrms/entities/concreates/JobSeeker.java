package kodlamaio.hrms.entities.concreates;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Entity
@Table(name="job_seekers")
@NoArgsConstructor
@AllArgsConstructor
@PrimaryKeyJoinColumn(name="id")
//@JsonIgnoreProperties({"hibernateLazyInitializer","handler","user"})
public class JobSeeker  {
	@Id
	@Column(name="id")
	private int id;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="national_identity")
	private String nationalIdentity;
	
	@Column(name="birth_year")
	private LocalDate birthYear;
	
	//@OneToOne(fetch = FetchType.LAZY, targetEntity = User.class, cascade=CascadeType.ALL)
	@OneToOne()
	@JoinColumn(name = "id")
	@MapsId   
	private User user;
	
}
