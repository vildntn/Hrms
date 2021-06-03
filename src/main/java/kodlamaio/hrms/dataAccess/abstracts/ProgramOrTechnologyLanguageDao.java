package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concreates.ProgramOrTechnologyLanguage;



public interface ProgramOrTechnologyLanguageDao extends JpaRepository<ProgramOrTechnologyLanguage, Integer> {

}
