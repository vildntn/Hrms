package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concreates.Photo;

public interface PhotoDao extends JpaRepository<Photo, Integer> {

	@Query("Select user.id From Photo")
	int getById();
	
}
