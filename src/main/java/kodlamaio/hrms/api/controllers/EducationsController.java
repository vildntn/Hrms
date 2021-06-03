package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.EducationService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concreates.Education;
import kodlamaio.hrms.entities.dtos.CandidateEducationInfoSortedGradYearDto;



@RestController
@RequestMapping("/api/educations")
public class EducationsController {

	private EducationService EducationService;

	@Autowired
	public EducationsController(kodlamaio.hrms.business.abstracts.EducationService educationService) {
		super();
		EducationService = educationService;
	}

	@PostMapping("/add")
	public Result add(@RequestBody Education education){
		return EducationService.add(education);
	}
	
	@GetMapping("/getall")
	public DataResult<List<Education>> getAll(){
		return EducationService.getAll();
	}
	
	@GetMapping("/getAllEducationOrderByGraduatedDate")
	public DataResult<List<Education>> getAllEducationOrderByGraduatedDate(int id){
		return EducationService.getAllEducationOrderByGraduatedDate(id);
	}
}
