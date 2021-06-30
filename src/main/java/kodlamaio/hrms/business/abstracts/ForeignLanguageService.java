package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concreates.ForeignLanguage;

public interface ForeignLanguageService {

	Result add(ForeignLanguage foreignLanguage);
	Result delete(ForeignLanguage foreignLanguage);
	Result update (ForeignLanguage foreignLanguage);
}
