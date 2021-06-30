package kodlamaio.hrms.business.abstracts;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.core.utilities.results.Result;

public interface PhotoService {

	Result add(MultipartFile multipartFile, int id) throws IOException;
}
