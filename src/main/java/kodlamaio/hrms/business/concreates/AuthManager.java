package kodlamaio.hrms.business.concreates;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.AuthService;
import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.business.abstracts.EmailVerificationService;
import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.core.utilities.adapters.MernisService;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.entities.concreates.Candidate;
import kodlamaio.hrms.entities.concreates.Employer;
import kodlamaio.hrms.entities.concreates.User;

@Service
public class AuthManager implements AuthService{
	
	private CandidateService candidateService;
	private EmployerService employerService;
	private EmailVerificationService emailVerificationService;
	private MernisService mernisService;
	
    @Autowired
	public AuthManager(CandidateService candidateService, EmployerService employerService, 
			EmailVerificationService emailVerificationService,
			MernisService mernisService) {
		super();
		this.candidateService = candidateService;
		this.employerService=employerService;
		this.emailVerificationService=emailVerificationService;
		this.mernisService=mernisService;
	}
 
    
	@Override
	public Result registerByCandidate(Candidate candidate, String rePassword) {
		if(!checkIfUserReal(candidate.getFirstName(), candidate.getLastName())) {
			 return new ErrorResult("No such person was found.");
		}
		if(!checkForNullOfUserInfo(candidate)) {
	            return new ErrorResult("You must not leave any blank space.");
		}
		if(!checkIfUserExist(candidate.getEmail())) {
			 return new ErrorResult("Registration failed cause this e-mail address is already in use!");
		}
         if(checkIfNationalIdentityExist(candidate.getNationalIdentity())){
        	 return new ErrorResult("Someone with this nationality identity already exists!");
         }
         if(!checkEmailVerification(candidate.getEmail())) {
 			return new  ErrorResult("Verification failed!");
 		}
         if(!checkIfPasswordTrue(candidate.getPassword(), rePassword)) {
  			return new  ErrorResult("Passwords do not match! Check again!");
  		}
			//candidateService.add(candidate);
			return new SuccessResult("Registration is successful!");
	}

	@Override
	public Result registerByEmployer(Employer employer, String rePassword) {
		if(!checkIfEmployerExist(employer.getEmail())) {
			return new  ErrorResult("Registration failed cause this e-mail address is already in use!");
		}if(!checkForNullOfEmployerInfo(employer)) {
			return new  ErrorResult("You must not leave any blank space.");
		}if(!checkIfEmailAndDomainSame(employer.getEmail(),employer.getWebAddress())) {
			return new  ErrorResult("Please enter a valid e-mail address!");
		}
		
		if(!checkEmailVerification(employer.getEmail())) {
			return new  ErrorResult("Verification failed!");
		}
		  if(!checkIfPasswordTrue(employer.getPassword(), rePassword)) {
	  			return new  ErrorResult("Passwords do not match! Check again!");
	  		}
			//employerService.add(employer);
			return new SuccessResult("Registration is successful!");
	}

	@Override
	public boolean checkIfUserExist(String email) {
		if(candidateService.getByMail(email).getData()!=null) {
			return false;
			
		}else {
		return true;
		}
	}
	@Override
	public boolean checkIfEmployerExist(String email) {
		if(employerService.getByEmail(email).getData()!=null) {
              return false;
			
		}else {
		return true;
		}
	}
	
	
	private boolean checkForNullOfUserInfo(Candidate candidate) {
		if(!candidate.getFirstName().isEmpty()&& !candidate.getLastName().isEmpty()&&!candidate.getEmail().isEmpty()&&
				!candidate.getNationalIdentity().isEmpty()&&!candidate.getPassword().isEmpty()&&candidate.getBirthYear()!=null) {
			return true;
		}else {
			return false;
		}
	}
	
	private boolean checkForNullOfEmployerInfo(Employer employer) {
		if(!employer.getCompanyName().isEmpty()&&!employer.getEmail().isEmpty()&&!employer.getWebAddress().isEmpty()&&
				!employer.getPhoneNumber().isEmpty()&&!employer.getPassword().isEmpty()) {
			return true;
		}
		return false;
			
	}
	
	private boolean checkIfEmailAndDomainSame(String email , String webAddress) {
		String emailSplit = email.split("@")[1];
		if(!emailSplit.equals(webAddress)) {
			return false;
		}
		return true;
		
	}
	
	private boolean checkIfNationalIdentityExist(String nationalityIdentity){
		if(candidateService.getByNationalIdentity(nationalityIdentity)!=null) {
			return false;
		}
		return true;
	}
	
	
	private boolean checkEmailVerification(String email) {
		this.emailVerificationService.sendEmail(email);
        return true;
		
	}

	private boolean checkIfPasswordTrue(String password, String repeatPassword ) {
		if(!password.equals(repeatPassword)) {
			return false;
		}
		return true;
	}
	private boolean checkIfUserReal(String firstName, String lastName) {
		if(mernisService.validateOfUser(firstName, lastName)) {
			return true;
		}
		return false;
	}

}
