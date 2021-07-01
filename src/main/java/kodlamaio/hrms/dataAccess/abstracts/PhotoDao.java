package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concreates.Photo;

public interface PhotoDao extends JpaRepository<Photo, Integer> {

	
	Photo getByUserId(int id);
	
}
