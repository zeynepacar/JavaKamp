package business.concretes;

import java.util.List;

import business.abstracts.UserService;
import dataAccess.abstracts.UserDao;
import entities.concretes.User;

public class UserManager implements UserService{

	UserRegistrationManager registerManager;
	UserDao userDao;
	
	
	public UserManager(UserRegistrationManager registerManager, UserDao userDao) {
		super();
		this.registerManager = registerManager;
		this.userDao = userDao;
	}

	@Override
	public void signUp(User user) {
		if(registerManager.isValidUser(user)) {
			System.out.println("Kullanıcı sisteme kaydoldu: " + user.getFirstName() + " " + user.getLastName());
			System.out.println("Kullanıcıya doğrulama epostası gönderilmiştir.\nÜyelik tamamlandı.");
			this.userDao.add(user);
		} else {
			System.out.println("Kullanıcı kayıt işlemi başarısız!");
		}
		
	}

	@Override
	public void logIn(String email, String password) {
				if(registerManager.userEmails.contains(email) && password.length() >= 6 ) {
					System.out.println("Kullanıcı girişi başarılı: " + email);
				} else {
					System.out.println("Hatalı bilgi girişi!");
				}
	}

	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
