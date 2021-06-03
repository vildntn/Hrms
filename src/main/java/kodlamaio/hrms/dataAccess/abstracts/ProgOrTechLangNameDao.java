package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concreates.ProgOrTechLangName;



public interface ProgOrTechLangNameDao  extends JpaRepository<ProgOrTechLangName, Integer> {

}
