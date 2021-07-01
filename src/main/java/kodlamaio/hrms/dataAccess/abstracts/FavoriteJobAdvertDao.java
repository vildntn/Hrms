package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concreates.FavoriteJobAdvert;

public interface FavoriteJobAdvertDao extends JpaRepository<FavoriteJobAdvert, Integer> {

}
