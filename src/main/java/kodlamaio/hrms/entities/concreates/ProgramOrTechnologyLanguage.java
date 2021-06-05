package kodlamaio.hrms.entities.concreates;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="program_or_technology_languages")
@NoArgsConstructor
@AllArgsConstructor
public class ProgramOrTechnologyLanguage {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name="cv_id")
	private CurriculumVitae curriculumVitae;
	
	@ManyToOne
	@JoinColumn(name="type_name_id")
	private ProgOrTechLangType progOrTechLangType;
	
	@ManyToOne
	@JoinColumn(name="language_id")
	private ProgOrTechLangName progOrTechLangName;

}
