package engineeringthesis.androidrestapi.game.domain;

import java.time.LocalDateTime;


import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

import engineeringthesis.androidrestapi.category.domain.CategoryEntity;
import engineeringthesis.androidrestapi.language.domain.LanguageEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "gameplay")
@Data 
@NoArgsConstructor @AllArgsConstructor
@Builder
class Gameplay {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "gameplay_id_pk")
	private Integer gameplayId;
	
	@OneToOne
	@JoinColumn(name = "language_id_fk")
	private LanguageEntity languageId;
	
	@OneToOne
	@JoinColumn(name = "game_id_fk")
	private Game gameId;
	
	@OneToOne
	@JoinColumn(name = "category_id_fk")
	private CategoryEntity categoryId;
	
	/*
	@OneToOne
	@JoinColumn(name = "child_id_fk")
	private ChildEntity childId;
	*/
	
	@Column(name = "gameplay_starting_date")
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)  
	@JsonSerialize(using = LocalDateTimeSerializer.class)  
	@DateTimeFormat(pattern = "uuuu-MM-dd'T'HH:mm:ss.SSSX")
		private LocalDateTime gameMatchDataStart;
	
	@Column(name = "gameplay_ending_date")
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)  
	@JsonSerialize(using = LocalDateTimeSerializer.class)  
	@DateTimeFormat(pattern = "uuuu-MM-dd'T'HH:mm:ss.SSSX")
		private LocalDateTime gameMatchDataEnd;
	
	@Column(name = "quest_uuid_fk")
	private String questUUID;
	

}
