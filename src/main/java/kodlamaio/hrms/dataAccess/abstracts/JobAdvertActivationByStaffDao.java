package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concreates.JobAdvertActivationByStaff;

public interface JobAdvertActivationByStaffDao extends JpaRepository<JobAdvertActivationByStaff, Integer> {

	JobAdvertActivationByStaff findByJobAdvertisementId(int id);
}
