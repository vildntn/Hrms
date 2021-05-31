package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.domain.Sort;
import kodlamaio.hrms.entities.concreates.JobAdvertisement;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer>{

	@Query("From JobAdvertisement where status=true")
	List<JobAdvertisement> getActiveJobPosting();
	
	@Query("From JobAdvertisement where status=true and employer_id=:id")
	List<JobAdvertisement> getAllActiveJobPostingByEmployer(int id);
	
	//değişicek //değişmeli //uyuyorum , beynim iptal
	@Query("From JobAdvertisement where status=true")
	List<JobAdvertisement> getAllActiveJobPostingByDate(Sort sort);
	
	JobAdvertisement findById(int id);
	
}
