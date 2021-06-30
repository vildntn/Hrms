package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concreates.JobAdvertisement;
import kodlamaio.hrms.entities.dtos.JobAdvertisementDto;

import org.springframework.data.domain.Sort;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer>{

	@Query("From JobAdvertisement where status=true")
	List<JobAdvertisement> getActiveJobAdvertisement();
	
	@Query("From JobAdvertisement where status=true and employer_id=:id")
	List<JobAdvertisement> getAllActiveJobAdvertisementByEmployer(int id);
	
	//değişicek //değişmeli //uyuyorum , beynim iptal
	@Query("From JobAdvertisement where status=true")
	List<JobAdvertisement> getAllActiveJobAdvertisementByDate(Sort sort);
	
	@Query("Select new kodlamaio.hrms.entities.dtos.JobAdvertisementDto(j.id, jb.jobTitle, e.companyName, c.city,"+
	"j.minSalary,j.maxSalary, j.openPosition,j.applicationDeadline, w.workType,jt.jobType)"
			+"From JobAdvertisement j Inner Join j.city c Inner Join j.employer e Inner Join j.workType w Inner Join j.jobType jt "+
			" Inner Join j.jobPosition jb where j.status=true")
	List<JobAdvertisementDto> getAllActiveJobAdvertisement();
	JobAdvertisement findById(int id);
	
		
}
