package kodlamaio.hrms.entities.concreates;





import java.sql.Date;
import java.time.LocalDate;

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
	
	@Column(name="is_confirmed")
	private boolean is_confirmed;
	
	@Column(name="confirmed_date")
	private LocalDate confirmed_date;
	
	@Column(name="status")
	private boolean status;
	
	@Column(name="created_date")
	private LocalDate createdDate;
	
	
}
