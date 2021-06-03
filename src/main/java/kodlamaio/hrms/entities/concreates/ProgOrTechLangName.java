package kodlamaio.hrms.entities.concreates;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="prog_or_tech_names")
@NoArgsConstructor
@AllArgsConstructor
public class ProgOrTechLangName {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@ManyToOne()
	@JoinColumn(name="prog_or_tech_type_id")
	private ProgOrTechLangType progOrTechLangType;
	
	@Column(name="prog_or_tech_name")
	private String progOrTechName;
}
