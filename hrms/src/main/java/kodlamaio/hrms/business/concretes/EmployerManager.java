package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.core.verifications.abstracts.EmailVerificationService;
import kodlamaio.hrms.core.verifications.abstracts.HrmsVerificationService;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService{
	
	private EmployerDao employerDao;
	private EmailVerificationService emailVerificationService;
	private HrmsVerificationService hrmsVerificationService;

	@Autowired
	public EmployerManager(EmployerDao employerDao, EmailVerificationService emailVerificationService,
			HrmsVerificationService hrmsVerificationService) {
		super();
		this.employerDao = employerDao;
		this.emailVerificationService = emailVerificationService;
		this.hrmsVerificationService = hrmsVerificationService;
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(), "Şirketler listelendi.");
	}
	
	public Result checkInformationIsFull(Employer employer) {
		if(employer.getCompanyName().isEmpty() || employer.getEmail().isEmpty() || employer.getPassword().isEmpty() || employer.getPhoneNumber().isEmpty() || employer.getWebAdress().isEmpty()) {
			return new ErrorResult("Lütfen tüm alanları doldurunuz.");
		} else {
			return new SuccessResult("");
		}
	}
	
	public Result isEmailUsed(String email) {
		if(this.employerDao.findByEmail(email) == null) {
			return new SuccessResult("");
		} else {
			return new ErrorResult("Bu email ile daha önce kayıt yapılmış!");
		}
	}

	@Override
	public Result add(Employer employer) {
		if(checkInformationIsFull(employer).isSuccess() && isEmailUsed(employer.getEmail()).isSuccess()) {
			this.employerDao.save(employer);
			System.out.println(this.emailVerificationService.verifyAccount(employer.getEmail()).getMessage());
			System.out.println(this.hrmsVerificationService.verifyAccount().getMessage());
			return new SuccessResult("İş veren başarıyla eklendi: " + employer.getCompanyName());
		} else {
			return new ErrorResult(checkInformationIsFull(employer).getMessage() + isEmailUsed(employer.getEmail()).getMessage());
		}
	}
	
	

}
