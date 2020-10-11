package engineeringthesis.androidrestapi.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "language")
@Data
@NoArgsConstructor @AllArgsConstructor
@Builder
public class LanguageEntity {

		@Id
    	@GeneratedValue(strategy = GenerationType.IDENTITY)
    	@Column(name = "language_id_pk")
		private Integer languageId;
	
		@Column(name = "language_name")
		private String languageName;
		
	
		//@Column(name = "language_icon")
		//private String languageImageIcon;
		
		@Column(name = "language_date_created")
		@DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss",iso = DateTimeFormat.ISO.DATE_TIME)
		@JsonSerialize(using = LocalDateTimeSerializer.class) 
		@JsonDeserialize(using = LocalDateTimeDeserializer.class) 
		@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
		private LocalDateTime languageCreatedDate;	
		
		@Column(name = "is_new", columnDefinition="BIT")
		private boolean isNew;
		
		@Column(name = "is_accepted", columnDefinition="BIT")
		private boolean isAccepted;
}
