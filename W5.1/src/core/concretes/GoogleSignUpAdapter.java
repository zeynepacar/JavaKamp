package core.concretes;

import core.abstracts.SignUpService;

public class GoogleSignUpAdapter implements SignUpService {

	@Override
	public void signUp(String message) {
		System.out.println("Google hesabı ile üye olundu.");		
	}

}
