package kodlamaio.hrms.entities.concreates;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="job_advert_activation_by_staff")
@NoArgsConstructor
@AllArgsConstructor
public class JobAdvertActivationByStaff {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	
	@ManyToOne
	@JoinColumn(name="job_advert_id")
	private JobAdvertisement jobAdvertisement;
	
	
	@ManyToOne
	@JoinColumn(name="staff_id")
	private Staff staff;
	
	
	@Column(name="is_confirmed")
	private boolean isConfirmed;
	
	
	@Column(name="confirmed_date")
	private LocalDateTime confirmedDate = LocalDateTime.now();;
}
