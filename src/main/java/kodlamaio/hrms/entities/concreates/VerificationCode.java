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
@Table(name="verification_codes")
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class VerificationCode {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	private User user;
	
	@Column(name="activation_code")
	private String activationCode;
	
	@Column(name="activation_date")
	private Date activationdate;
	
	@Column(name="is_activated")
	private boolean isActivated;
	
	@Column(name="created_date")
	private Date createdDate;
	
	@Column(name="status")
	private boolean status;
	

}
