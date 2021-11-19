package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concreates.City;

public interface CityService {

	DataResult<List<City>> getAll();
	DataResult<City> getById(int id);
	Result add(City city);
}
