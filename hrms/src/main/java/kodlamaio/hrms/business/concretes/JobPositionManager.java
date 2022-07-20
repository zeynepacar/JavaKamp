package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kodlamaio.hrms.business.abstracts.JobPositionService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobPositionDao;
import kodlamaio.hrms.entities.concretes.JobPosition;

@Service
public class JobPositionManager implements JobPositionService {
	
	private JobPositionDao jobPositionDao;

	@Autowired
	public JobPositionManager(JobPositionDao jobPositionDao) {
		super();
		this.jobPositionDao = jobPositionDao;
	}

	@Override
	public DataResult<List<JobPosition>> getAll() {
				return new SuccessDataResult<List<JobPosition>>(this.jobPositionDao.findAll(),"İş pozisyonları listelendi.");
	}

	@Override
	public Result add(JobPosition position) {
		if(isJobPositionExist(position.getTitle()).isSuccess()) {
			this.jobPositionDao.save(position);
			return new SuccessResult("Pozisyon başarıyla eklendi: " + position.getTitle());
			
		} else {
			return new ErrorResult("Bu pozisyon daha önce eklenmiş: " + position.getTitle());
	
		}
	}

	public Result isJobPositionExist(String jobTitle) {
	
		if(this.jobPositionDao.findByName(jobTitle) == null) {
			return new SuccessResult();
		} else {
			return new ErrorResult();
		}
	}


}
