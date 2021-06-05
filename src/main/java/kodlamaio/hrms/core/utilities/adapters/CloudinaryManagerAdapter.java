package kodlamaio.hrms.core.utilities.adapters;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.CloudinaryService.CloudinaryManager;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
@Service
public class CloudinaryManagerAdapter implements CloudinaryService{
	private CloudinaryManager cloudinaryManager;
	@Autowired
	public CloudinaryManagerAdapter(CloudinaryManager cloudinaryManager) {
		super();
		this.cloudinaryManager = cloudinaryManager;
	}

	@Override
	public Map upload(MultipartFile multipartFile) throws IOException {
		return cloudinaryManager.upload(multipartFile);
	}

}
