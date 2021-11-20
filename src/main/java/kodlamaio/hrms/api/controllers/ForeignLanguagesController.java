package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.FavoriteJobAdvertService;
import kodlamaio.hrms.business.abstracts.ForeignLanguageService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concreates.FavoriteJobAdvert;
import kodlamaio.hrms.entities.concreates.ForeignLanguage;


@RestController
@RequestMapping("/api/foreignLanguages")
public class ForeignLanguagesController {

	private ForeignLanguageService foreignLanguageService;
	
	
	@Autowired
	public ForeignLanguagesController(ForeignLanguageService foreignLanguageService) {
		super();
		this.foreignLanguageService = foreignLanguageService;
	}

	@PostMapping("/add")
	public Result add(@RequestBody ForeignLanguage ForeignLanguage){
		return foreignLanguageService.add(ForeignLanguage);
	}
	
	@GetMapping("/getall")
	public DataResult<List<ForeignLanguage>> getAll(){
		return foreignLanguageService.getAll();
	}
	
	@GetMapping("/getById")
	public DataResult<ForeignLanguage> getById(int id){
		return foreignLanguageService.getById(id);
	}
	
	@PostMapping("/delete")
	public Result delete(@RequestBody ForeignLanguage ForeignLanguage){
		return foreignLanguageService.delete(ForeignLanguage);
	}
	
	@PostMapping("/update")
	public Result update(@RequestBody ForeignLanguage ForeignLanguage){
		return foreignLanguageService.update(ForeignLanguage);
	}
}
