package kodlamaio.hrms.business.concreates;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.AuthService;
import kodlamaio.hrms.business.abstracts.JobSeekerService;
import kodlamaio.hrms.business.abstracts.EmailVerificationService;
import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.core.utilities.adapters.MernisService;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.entities.concreates.JobSeeker;
import kodlamaio.hrms.entities.concreates.Employer;
import kodlamaio.hrms.entities.concreates.User;

@Service
public class AuthManager implements AuthService{
	
	private JobSeekerService jobSeekerService;
	private EmployerService employerService;
	private EmailVerificationService emailVerificationService;
	private MernisService mernisService;
	
    @Autowired
	public AuthManager(JobSeekerService jobSeekerService, EmployerService employerService, 
			EmailVerificationService emailVerificationService,
			MernisService mernisService) {
		super();
		this.jobSeekerService = jobSeekerService;
		this.employerService=employerService;
		this.emailVerificationService=emailVerificationService;
		this.mernisService=mernisService;
	}
 
    
	@Override
	public Result registerByJobSeeker(JobSeeker jobSeeker, String rePassword) {
		if(!checkIfUserReal(jobSeeker.getFirstName(), jobSeeker.getLastName())) {
			 return new ErrorResult("No such person was found.");
		}
		if(!checkForNullOfUserInfo(jobSeeker)) {
	            return new ErrorResult("You must not leave any blank space.");
		}
		if(!checkIfUserExist(jobSeeker.getUser().getEmail())) {
			 return new ErrorResult("Registration failed cause this e-mail address is already in use!");
		}
         if(checkIfNationalIdentityExist(jobSeeker.getNationalIdentity())){
        	 return new ErrorResult("Someone with this nationality identity already exists!");
         }
         if(!checkEmailVerification(jobSeeker.getUser().getEmail())) {
 			return new  ErrorResult("Verification failed!");
 		}
         if(!checkIfPasswordTrue(jobSeeker.getUser().getPassword(), rePassword)) {
  			return new  ErrorResult("Passwords do not match! Check again!");
  		}
			//candidateService.add(candidate);
			return new SuccessResult("Registration is successful!");
	}

	@Override
	public Result registerByEmployer(Employer employer, String rePassword) {
		if(!checkIfEmployerExist(employer.getUser().getEmail())) {
			return new  ErrorResult("Registration failed cause this e-mail address is already in use!");
		}
		if(!checkForNullOfEmployerInfo(employer)) {
			return new  ErrorResult("You must not leave any blank space.");
		}if(!checkIfEmailAndDomainSame(employer.getUser().getEmail(),employer.getWebAddress())) {
			return new  ErrorResult("Please enter a valid e-mail address!");
		}
		
		if(!checkEmailVerification(employer.getUser().getEmail())) {
			return new  ErrorResult("Verification failed!");
		}
		  if(!checkIfPasswordTrue(employer.getUser().getPassword(), rePassword)) {
	  			return new  ErrorResult("Passwords do not match! Check again!");
	  		}
			//employerService.add(employer);
			return new SuccessResult("Registration is successful!");
	}

	@Override
	public boolean checkIfUserExist(String email) {
		if(jobSeekerService.getByMail(email).getData()!=null) {
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
	
	
	private boolean checkForNullOfUserInfo(JobSeeker jobSeeker) {
		if(!jobSeeker.getFirstName().isEmpty()&& !jobSeeker.getLastName().isEmpty()&&!jobSeeker.getUser().getEmail().isEmpty()
				&&!jobSeeker.getUser().getPassword().isEmpty()&&
				!jobSeeker.getNationalIdentity().isEmpty()&&jobSeeker.getBirthYear()!=null) {
			return true;
		}else {
			return false;
		}
	}
	
	private boolean checkForNullOfEmployerInfo(Employer employer) {
		if(!employer.getCompanyName().isEmpty()&&!employer.getUser().getEmail().isEmpty()&&!employer.getWebAddress().isEmpty()&&
				!employer.getPhoneNumber().isEmpty()&&!employer.getUser().getEmail().isEmpty()) {
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
		if(jobSeekerService.getByNationalIdentity(nationalityIdentity)!=null) {
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
