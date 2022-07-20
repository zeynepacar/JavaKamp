package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import kodlamaio.hrms.entities.concretes.JobPosition;

@Repository
public interface JobPositionDao extends JpaRepository<JobPosition, Integer> {
	
	@Query(value = "SELECT jobPosition FROM JobPosition jobPosition WHERE jobPosition.title = ?1")
	JobPosition findByName(String title);

}
