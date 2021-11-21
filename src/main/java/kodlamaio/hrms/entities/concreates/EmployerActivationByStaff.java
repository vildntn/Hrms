package kodlamaio.hrms.entities.concreates;





import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

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
@Table(name="employers_activation_by_staff")
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class EmployerActivationByStaff {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@ManyToOne()
	@JoinColumn(name="employers_id")
	private Employer employer;
	
	@ManyToOne()
	@JoinColumn(name="staffs_id")
	private Staff staff;
	
	
	@Column(name="confirmed_date")
	private LocalDateTime confirmedDate=LocalDateTime.now();
	
	@Column(name="status")
	private boolean status;
	

	
}
