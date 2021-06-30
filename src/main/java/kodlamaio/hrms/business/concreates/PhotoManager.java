package kodlamaio.hrms.business.concreates;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.business.abstracts.PhotoService;
import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.core.utilities.adapters.CloudinaryService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.PhotoDao;
import kodlamaio.hrms.entities.concreates.CurriculumVitae;
import kodlamaio.hrms.entities.concreates.Photo;
@Service
public class PhotoManager implements PhotoService {

	private PhotoDao photoDao;
	private CloudinaryService cloudinaryService;
	
	@Autowired
	public PhotoManager(PhotoDao photoDao ,CloudinaryService CloudinaryService) {
		super();
		this.photoDao = photoDao;

		this.cloudinaryService=cloudinaryService;
	}

	

	@Override
	public Result add(MultipartFile file, int id) throws IOException {
		Map map = cloudinaryService.upload(file);
		String photoUrl=map.get("url").toString();
        Photo photo=photoDao.getOne(id);
//		cv.setPhotoUrl(photoUrl);
//		curriculumVitaeDao.save(cv);
//		if(photoDao.getById()!=id) {
//			photoDao.save(file)
//		}
		return new SuccessResult("Photo added");
	}
}
