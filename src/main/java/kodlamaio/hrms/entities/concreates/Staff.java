package kodlamaio.hrms.entities.concreates;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Entity
@PrimaryKeyJoinColumn(name="id")
@Table(name="staffs")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@AllArgsConstructor
@NoArgsConstructor
public class Staff extends User {

	@Id
	@Column(name="id")
	private int id;
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
//	@OneToOne(fetch = FetchType.LAZY, targetEntity = User.class, cascade=CascadeType.ALL)
//	@JoinColumn(name = "id")
//	private User user;
	

}
