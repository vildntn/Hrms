package kodlamaio.hrms.business.concreates;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.business.abstracts.PhotoService;
import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.core.utilities.adapters.CloudinaryService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.PhotoDao;
import kodlamaio.hrms.entities.concreates.CurriculumVitae;
import kodlamaio.hrms.entities.concreates.Photo;
import kodlamaio.hrms.entities.concreates.User;
@Service
public class PhotoManager implements PhotoService {

	private PhotoDao photoDao;
	private CloudinaryService cloudinaryService;
	private UserService userService;
	
	@Autowired
	public PhotoManager(PhotoDao photoDao ,CloudinaryService cloudinaryService, UserService userService) {
		super();
		this.photoDao = photoDao;
        this.userService=userService;
		this.cloudinaryService=cloudinaryService;
	}

	

	@Override
	public Result add(MultipartFile file, int id) throws IOException {
		Map map = cloudinaryService.upload(file);
		String photoUrl=map.get("url").toString();
        User user=userService.getById(id).getData();
        //this must change
        Photo photo =new Photo();
        photo.setUser(user);
        photo.setPhotoUrl(photoUrl);
        photo.setStatus(true);
        photo.setConfirmedDate(LocalDateTime.now());
        photoDao.save(photo);
		return new SuccessResult("Photo added");
	}



	@Override
	public DataResult<Photo> getByUserId(int id) {
		return new SuccessDataResult<Photo>(photoDao.getByUserId(id));
	}
}
