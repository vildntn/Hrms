package kodlamaio.hrms.mernisService;

public class FakeMernisManager {

	public boolean validateOf(String firstName, String lastName) {
		System.out.println(firstName+" "+lastName+" Mernis ile doğrulandı");
		return true;
	}
}
