package kodlamaio.hrms.business.abstracts;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concreates.Photo;

public interface PhotoService {

	Result add(MultipartFile multipartFile, int id) throws IOException;
	
	DataResult<Photo> getByUserId(int id);
}
