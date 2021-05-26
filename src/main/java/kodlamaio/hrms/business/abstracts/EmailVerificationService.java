package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.Result;

public interface EmailVerificationService {

	boolean sendEmail(String email);
	
}
