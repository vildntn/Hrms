package kodlamaio.hrms.entities.concreates;

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
@Table(name="favorite_job_advert")
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler","jobAdvertisement","jobSeeker"})
public class FavoriteJobAdvert {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@ManyToOne
	@JoinColumn(name="job_seeker_id")
	private JobSeeker jobSeeker;
	
	@ManyToOne
	@JoinColumn(name="job_advert_id")
	private JobAdvertisement jobAdvertisement;
	
	@Column(name="status")
	private boolean status;
}
