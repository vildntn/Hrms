package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concreates.WorkType;

public interface WorkTypeDao extends JpaRepository<WorkType, Integer>{

}
