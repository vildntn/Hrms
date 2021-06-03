package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concreates.EducationDegree;



public interface EducationDegreeDao  extends JpaRepository<EducationDegree, Integer> {

}
