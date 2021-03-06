package kodlamaio.hrms.business.concreates;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CityService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CityDao;
import kodlamaio.hrms.entities.concreates.City;
@Service
public class CityManager implements CityService {
	
	private CityDao cityDao;
	
     @Autowired
	public CityManager(CityDao cityDao) {
		super();
		this.cityDao = cityDao;
	}
	@Override
	public DataResult<List<City>> getAll() {
		return new SuccessDataResult<List<City>>(cityDao.findAll());
	}
	@Override
	public Result add(City city) {
		cityDao.save(city);
		return new SuccessResult("New city Added!");
	}
	@Override
	public DataResult<City> getById(int id) {
		return new SuccessDataResult<City>(cityDao.getOne(id));
	}
	
}
