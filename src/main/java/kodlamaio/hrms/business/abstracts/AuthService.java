package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concreates.JobSeeker;
import kodlamaio.hrms.entities.concreates.Employer;
import kodlamaio.hrms.entities.concreates.User;

public interface AuthService {

	
	 Result registerByJobSeeker(JobSeeker jobSeeker, String rePassword);
	 Result registerByEmployer(Employer employer, String rePassword);
	 boolean checkIfUserExist(String email);
	 boolean checkIfEmployerExist(String email);
}
