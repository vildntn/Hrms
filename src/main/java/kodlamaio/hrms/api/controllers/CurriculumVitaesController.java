package kodlamaio.hrms.api.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.business.abstracts.CurriculumVitaeService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concreates.CurriculumVitae;



@RestController
@RequestMapping("/api/curriculumVitaes")
public class CurriculumVitaesController {
	

	private CurriculumVitaeService curriculumVitaeService;

	@Autowired
	public CurriculumVitaesController( CurriculumVitaeService curriculumVitaeService) {
		super();
		this.curriculumVitaeService = curriculumVitaeService;
	}
	
	
	
	@PostMapping("/add")
	public Result add(@RequestBody CurriculumVitae curriculumVitae){
		return curriculumVitaeService.add(curriculumVitae);
	}
	
	@GetMapping("/getall")
	public DataResult<List<CurriculumVitae>> getAll(){
		return curriculumVitaeService.getAll();
	}
	
	@GetMapping("/getCurriculumVitaeByCandidateId")
	public DataResult<CurriculumVitae> getCurriculumVitaeByCandidateId(int id){
		return curriculumVitaeService.getCurriculumVitaeByCandidateId(id);
	}
	

	@PutMapping("/photoUpload")
	public Result saveImage(@RequestBody MultipartFile file,@RequestParam int cvId) throws IOException {
		return this.curriculumVitaeService.addPhoto(file, cvId);
		
	}
	
	
}
