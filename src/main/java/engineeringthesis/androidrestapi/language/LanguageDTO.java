package engineeringthesis.androidrestapi.language;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LanguageDTO {
	
	private Integer languageId;

	private String languageName;
	
	//private String languageImageIcon;
	
	private LocalDateTime languageCreatedDate;	
	
	private boolean isNew;
	
	private boolean isAccepted;
}
