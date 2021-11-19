package kodlamaio.hrms.business.concreates;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.FavoriteJobAdvertService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.FavoriteJobAdvertDao;
import kodlamaio.hrms.entities.concreates.FavoriteJobAdvert;

@Service
public class FavoriteJobAdvertManager implements FavoriteJobAdvertService {

	
	private FavoriteJobAdvertDao favoriteJobAdvertDao;

	
	@Autowired
	public FavoriteJobAdvertManager(FavoriteJobAdvertDao favoriteJobAdvertDao) {
		super();
		this.favoriteJobAdvertDao = favoriteJobAdvertDao;
	}


	@Override
	public Result add(FavoriteJobAdvert favoriteJobAdvert) {
		favoriteJobAdvertDao.save(favoriteJobAdvert);
		return new SuccessResult("New favorite job Advertisement added.");
	}


	@Override
	public Result delete(FavoriteJobAdvert favoriteJobAdvert) {
		favoriteJobAdvertDao.delete(favoriteJobAdvert);
		return new SuccessResult("Job advert deleted");
	}

	@Override
	public DataResult<FavoriteJobAdvert> getById(int id) {
		return new SuccessDataResult<FavoriteJobAdvert>(favoriteJobAdvertDao.getOne(id));
	}


	@Override
	public DataResult<List<FavoriteJobAdvert>> getAll() {
		return new SuccessDataResult<List<FavoriteJobAdvert>>(favoriteJobAdvertDao.findAll());
	}


	@Override
	public DataResult<List<FavoriteJobAdvert>> getByJobSeekerId(int id) {
		return new SuccessDataResult<List<FavoriteJobAdvert>>(favoriteJobAdvertDao.findByJobSeekerId(id));
	}


	@Override
	public DataResult<List<FavoriteJobAdvert>> getByJobAdvertisementId(int id) {
		return new SuccessDataResult<List<FavoriteJobAdvert>>(favoriteJobAdvertDao.findByJobAdvertisementId(id));
	}
}
