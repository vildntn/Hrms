package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concreates.FavoriteJobAdvert;

public interface FavoriteJobAdvertDao extends JpaRepository<FavoriteJobAdvert, Integer> {

	List<FavoriteJobAdvert> findByJobSeekerId(int id);
	List<FavoriteJobAdvert> findByJobAdvertisementId(int id);
}
