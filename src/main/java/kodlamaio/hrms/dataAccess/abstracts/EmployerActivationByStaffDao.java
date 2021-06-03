package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concreates.EmployerActivationByStaff;


public interface EmployerActivationByStaffDao  extends JpaRepository<EmployerActivationByStaff, Integer>{

}
