package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.EducationService;
import kodlamaio.hrms.business.abstracts.FavoriteJobAdvertService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concreates.Education;
import kodlamaio.hrms.entities.concreates.FavoriteJobAdvert;



@RestController
@RequestMapping("/api/favoriteJobAdverts")
public class FavoriteJobAdvertsController {


	private FavoriteJobAdvertService favoriteJobAdvertService;

	@Autowired
	public FavoriteJobAdvertsController(FavoriteJobAdvertService favoriteJobAdvertService) {
		super();
		this.favoriteJobAdvertService = favoriteJobAdvertService;
	}

	@PostMapping("/add")
	public Result add(@RequestBody FavoriteJobAdvert favoriteJobAdvert){
		return favoriteJobAdvertService.add(favoriteJobAdvert);
	}
	
	@GetMapping("/getall")
	public DataResult<List<FavoriteJobAdvert>> getAll(){
		return favoriteJobAdvertService.getAll();
	}
	
	@GetMapping("/getById")
	public DataResult<FavoriteJobAdvert> getById(int id){
		return favoriteJobAdvertService.getById(id);
	}
	
	@PostMapping("/delete")
	public Result delete(@RequestBody FavoriteJobAdvert favoriteJobAdvert){
		return favoriteJobAdvertService.delete(favoriteJobAdvert);
	}
}
