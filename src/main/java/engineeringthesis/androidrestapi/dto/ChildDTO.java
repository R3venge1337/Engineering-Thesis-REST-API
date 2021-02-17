package engineeringthesis.androidrestapi.dto;


import engineeringthesis.androidrestapi.entity.AccountEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChildDTO {

	private Integer childId;
	
	private String childName;
	
	private String childSurname;

	private Short childYearBirth;
	
	private String childCity;
	
	private String childQuestUUID;
	
	private AccountEntity accountChildId;
}
