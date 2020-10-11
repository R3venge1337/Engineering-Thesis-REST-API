package engineeringthesis.androidrestapi.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccountDTO {
	
	private Integer accountId;
	
	private String accountName;
	
	private String accountPassword;
	
	private LocalDateTime accountCreatedDate;
	
	private String accountEmail;
}
