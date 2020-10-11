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

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

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
	
	@OneToOne
	@JoinColumn(name = "child_id_fk")
	private ChildEntity childId;
	
	
	@Column(name = "gameplay_starting_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	@JsonDeserialize(using = LocalDateDeserializer.class)  
	@JsonSerialize(using = LocalDateSerializer.class)  
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
		private LocalDateTime gameMatchDataStart;
	
	@Column(name = "gameplay_ending_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	@JsonDeserialize(using = LocalDateDeserializer.class)  
	@JsonSerialize(using = LocalDateSerializer.class)  
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
		private LocalDateTime gameMatchDataEnd;
	

}
