package business.concretes;

import business.abstracts.UserRegistrationService;
import entities.concretes.User;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.*;

public class UserRegistrationManager implements UserRegistrationService {
	
	List<String> userEmails;
	
	public UserRegistrationManager() {
		this.userEmails = new ArrayList<String>();
	}

	@Override
	public boolean checkFirstName(User user) {
		if(user.getFirstName().length() >= 2) {
			return true;
		} else {
			System.out.println("Geçerli bir isim değil en az 2 karakter olmalı!");
			return false;
		}
		
	}

	@Override
	public boolean checkLastName(User user) {
		if(user.getLastName().length() >= 2) {
			return true;
		} else { 
			System.out.println("Geçerli bir soyad değil en az 2 karakter olmalı!");
			return false;
			
		}
	}

	@Override
	public boolean checkEmail(User user) {
		 String regex = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
		 Pattern pattern = Pattern.compile(regex);
		 if(pattern.matcher(user.geteMail()).find() && !userEmails.contains(user.geteMail())) {
			 System.out.println("Email sisteme eklendi.");
			 userEmails.add(user.geteMail());
			 return true;
		 } else {
			 if(userEmails.contains(user.geteMail())) {
				 System.out.println("Email zaten kullanılmış! " + user.geteMail() );
			 } else {
				 System.out.println("Geçersiz email!");
			 }
			 return false;
		 }
				
	}

	@Override
	public boolean checkPassword(User user) {
		if(user.getPassword().length() >= 6) {
			return true;
		} else { 
			System.out.println("Şifre en az 6 karekter uzunluğunda olmalıdır!");
			return false;
		}
	}

	@Override
	public boolean isValidUser(User user) {
		if(checkFirstName(user) && checkLastName(user) && checkEmail(user) && checkPassword(user)) {
			return true;
		} else {
			return false;
		}
	}
	
	

}
