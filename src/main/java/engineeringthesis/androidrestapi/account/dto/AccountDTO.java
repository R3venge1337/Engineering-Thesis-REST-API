package engineeringthesis.androidrestapi.account.dto;

import java.time.LocalDateTime;

import engineeringthesis.androidrestapi.role.domain.RoleEntity;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccountDTO {
	
	@Setter(value = AccessLevel.PACKAGE)
	private Integer accountId;
	
	@Setter(value = AccessLevel.PACKAGE)
	private String accountName;
	
	@Setter(value = AccessLevel.PACKAGE)
	private String accountPassword;
	
	@Setter(value = AccessLevel.PACKAGE)
	private LocalDateTime accountCreatedDate;
	
	@Setter(value = AccessLevel.PACKAGE)
	private String accountEmail;
	
	@Setter(value = AccessLevel.PACKAGE)
	private RoleEntity role;
}
