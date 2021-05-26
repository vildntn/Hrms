package kodlamaio.hrms.core.utilities.adapters;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.mernisService.FakeMernisManager;
@Service
public class MernisManagerAdapter implements MernisService {

	@Override
	public boolean validateOfUser(String firstName, String lastName) {
		FakeMernisManager mernisManager=new FakeMernisManager();
		if(mernisManager.validateOf(firstName, lastName)) {
			return true;
		}
		return false;
		
	}

}
