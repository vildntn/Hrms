package kodlamaio.hrms.business.concreates;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmailVerificationService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
@Service
public class EmailVerificationManager implements EmailVerificationService{

	@Override
	public boolean sendEmail(String email) {
		System.out.println("Email adresi onaylandı: "+ email);
		return true;
	}

}
