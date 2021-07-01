package kodlamaio.hrms.dataAccess.abstracts;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concreates.Staff;

public interface StaffDao extends JpaRepository<Staff, Integer>{

	
	Staff getByUserEmail(String email);
	@Query("Select sf.user.email From Staff sf where sf.id=:id")
	String getEmail(int id);
}
