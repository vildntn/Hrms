package kodlamaio.hrms.core.utilities.adapters;

import java.io.IOException;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;


public interface CloudinaryService {
	public Map upload(MultipartFile multipartFile) throws IOException;
}
