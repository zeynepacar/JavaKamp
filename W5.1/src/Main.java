import business.abstracts.UserService;
import business.concretes.UserManager;
import business.concretes.UserRegistrationManager;
import dataAccess.concretes.HibernateUserDao;
import entities.concretes.User;

public class Main {

	public static void main(String[] args) {
		User user = new User(1, "Zeynep", "Acar", "zeynep@hotmail.com", "1234567");
		User user2 = new User(1, "Zeynep", "Acar", "zeynep@hotmail.com", "1234567");
		UserService manager = new UserManager(new UserRegistrationManager(), new HibernateUserDao());
		
		manager.signUp(user);
		manager.logIn(user.geteMail(), user.getPassword());
		manager.signUp(user2);
	}

}
