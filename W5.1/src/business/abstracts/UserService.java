package business.abstracts;

import java.util.List;

import entities.concretes.User;

public interface UserService {
	
	void signUp(User user);
	void logIn(String email, String password);
	List<User> getAll();

}
