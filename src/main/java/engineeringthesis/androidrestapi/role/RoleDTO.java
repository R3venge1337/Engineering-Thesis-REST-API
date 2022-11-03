package engineeringthesis.androidrestapi.role;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RoleDTO {
	
	private Integer roleId;
	
	private String roleName;
	
	private LocalDateTime roleCreatedDate;
}
