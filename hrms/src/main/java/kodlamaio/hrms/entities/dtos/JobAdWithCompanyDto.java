package kodlamaio.hrms.entities.dtos;

import java.time.LocalDateTime;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobAdWithCompanyDto {
	
	private String companyName;
	//private String jobTitle;
	private int openPositionCount;
	private LocalDateTime releaseDate;
	private Date applicationDeadline;
	

}
