package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concreates.Candidate;
import kodlamaio.hrms.entities.concreates.Employer;
import kodlamaio.hrms.entities.concreates.User;

public interface AuthService {

	
	 Result registerByCandidate(Candidate candidate, String rePassword);
	 Result registerByEmployer(Employer employer, String rePassword);
	 Result checkIfUserExist(String email);
	 Result checkIfEmployerExist(String email);
}
