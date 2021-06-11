package kodlamaio.hrms.dataAccess.abstracts;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concreates.Employer;

public interface EmployerDao extends JpaRepository<Employer, Integer> {

	Employer findByUserEmail(String email);
	Employer findByWebAddress(String webAddress);
}
