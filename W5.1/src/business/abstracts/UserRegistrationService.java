package business.abstracts;

import entities.concretes.User;

public interface UserRegistrationService {
	
	boolean checkFirstName(User user);
	boolean checkLastName(User user);
	boolean checkEmail(User user);
	boolean checkPassword(User user);
	boolean isValidUser(User user);

}
