package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concreates.FavoriteJobAdvert;

public interface FavoriteJobAdvertService {

	
	Result add(FavoriteJobAdvert favoriteJobAdvert);
	Result delete(FavoriteJobAdvert favoriteJobAdvert);
	DataResult<FavoriteJobAdvert> getById(int id);
	DataResult<List<FavoriteJobAdvert>> getAll();
	
}
