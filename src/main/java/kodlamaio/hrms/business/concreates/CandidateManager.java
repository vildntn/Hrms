package kodlamaio.hrms.business.concreates;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrms.entities.concreates.Candidate;

@Service
public class CandidateManager implements CandidateService {
	
	private CandidateDao candidateDao;

	@Autowired
	public CandidateManager(CandidateDao candidateDao) {
		super();
		this.candidateDao = candidateDao;
	}

	@Override
	public DataResult<List<Candidate>> getAll() {
		return new SuccessDataResult<List<Candidate>>(candidateDao.findAll(),"Tüm liste listelendi");
	}

	@Override
	public Result add(Candidate candidate) {
		candidateDao.save(candidate);
		return new SuccessResult("eklendi");
	}

	@Override
	public DataResult<List<Candidate>> getByMail(String email) {
		return new SuccessDataResult<List<Candidate>>(candidateDao.findByEmail(email));
	}

	@Override
	public DataResult<List<Candidate>> getByNationalIdentity(String nationalIdentity) {
		return new SuccessDataResult<List<Candidate>>(candidateDao.findByNationalIdentity(nationalIdentity));
	}
	
	
	
	

}
