package kodlamaio.hrms.CloudinaryService;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;


@Service
public class CloudinaryManager {

	 Cloudinary cloudinary;
	private Map<String, String> valuesMap=new HashMap<String, String>();
	@Autowired
	public CloudinaryManager() {
		valuesMap.put("cloud_name", "dlt5iokzt");
		valuesMap.put("api_key", "949585943282756");
		valuesMap.put("api_secret", "Y_bVD_ifFEIlg5PVkGeVFV0rPNM");
		cloudinary = new Cloudinary(valuesMap);
	}
	
	public Map upload(MultipartFile multipartFile) throws IOException {
		File file = convert(multipartFile);
		Map uploadResult =null;
		 uploadResult  = cloudinary.uploader().upload(file, ObjectUtils.emptyMap());

		file.delete();
		return uploadResult;
	}
	
	
	 public File convert(MultipartFile multipartFile) throws IOException {
	        File file = new File(multipartFile.getOriginalFilename());
	        FileOutputStream fileOutput = new FileOutputStream(file);
	        fileOutput.write(multipartFile.getBytes());
	        fileOutput.close();

	        return file;
	    }

}
