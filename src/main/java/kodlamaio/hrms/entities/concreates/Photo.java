package kodlamaio.hrms.entities.concreates;

import java.time.LocalDate;

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
@Table(name="photos")
@NoArgsConstructor
@AllArgsConstructor
public class Photo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@ManyToOne()
	@JoinColumn(name="user_id")
	private User user;
	
	@Column(name="photo_url")
	private String photoUrl;
	
	
	@Column(name="created_date")
	private LocalDate createdDate;
	
	@Column(name="status")
	private boolean status;

}
