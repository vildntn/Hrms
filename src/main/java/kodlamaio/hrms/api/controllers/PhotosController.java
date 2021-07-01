package kodlamaio.hrms.api.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


import kodlamaio.hrms.business.abstracts.PhotoService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concreates.Photo;

@RestController
@RequestMapping("/api/photos")
@CrossOrigin
public class PhotosController {


   private PhotoService photoService;

   @Autowired
	public PhotosController( PhotoService photoService) {
	  super();
	  this.photoService = photoService;
	}
			
			
    @PostMapping("/add")
	public Result add(@RequestBody MultipartFile file,@RequestParam int userId ) throws IOException{
			
      return photoService.add(file,userId );
			
    }
    
    @GetMapping("/getByUserId")
    public DataResult<Photo> getByUserId(int id){
    	return photoService.getByUserId(id);
    }
			
}
