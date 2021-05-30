package kodlamaio.hrms.entities.concreates;




import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@Entity
@Table(name="users")
@AllArgsConstructor
@Inheritance(strategy =InheritanceType.JOINED)
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="email")
	private String email;
	
	@Column(name="password")
	private String password;
	
	
	@Column(name="created_date")
	private Date createdDate;
	
	@Column(name="status")
	private boolean status;
	
//	@OneToOne(mappedBy = "user", cascade=CascadeType.ALL)
//	@PrimaryKeyJoinColumn
//	private Employer employer;
//	
	
	public User() {
		
	}

	
	

}
