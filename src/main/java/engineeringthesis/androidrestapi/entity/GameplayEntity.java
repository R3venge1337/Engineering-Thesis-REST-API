package engineeringthesis.androidrestapi.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "gameplay")
@Data 
@NoArgsConstructor @AllArgsConstructor
@Builder
public class GameplayEntity {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "gameplay_id_pk")
	private Integer gameplayId;
	
	@OneToOne
	@JoinColumn(name = "language_id_fk")
	private LanguageEntity languageId;
	
	@OneToOne
	@JoinColumn(name = "game_id_fk")
	private GameEntity gameId;
	
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
