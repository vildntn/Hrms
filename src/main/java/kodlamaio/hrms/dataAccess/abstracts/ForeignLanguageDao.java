package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concreates.ForeignLanguage;



public interface ForeignLanguageDao  extends JpaRepository<ForeignLanguage, Integer> {

}
