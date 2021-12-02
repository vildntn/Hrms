package kodlamaio.hrms.entities.concreates;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name="employers")
@AllArgsConstructor
@NoArgsConstructor
@PrimaryKeyJoinColumn(name="id")

public class Employer{
	@Id
	@Column(name="id")
	private int id;

	@Column(name="company_name")
	private String companyName;
	
	@Column(name="web_address")
	private String webAddress;
	
	@Column(name="phone_number")
	private String phoneNumber;
	

	@Column(name="address")
	private String address;
	
	@ManyToOne
	@JoinColumn(name="department_id")
	private Department department;
//	@OneToMany(mappedBy = "employer")
//	private List<JobAdvertisement> jobAdvertisements;
	
//	@OneToOne(targetEntity = User.class ,fetch = FetchType.LAZY, optional = false)
//	@JoinColumn(name = "id", referencedColumnName =  "id" ,nullable = false)
//	private User user;
	
	@OneToOne()
	@MapsId
	@JoinColumn(name="id")
	
	private User user;

	

	

	

}
