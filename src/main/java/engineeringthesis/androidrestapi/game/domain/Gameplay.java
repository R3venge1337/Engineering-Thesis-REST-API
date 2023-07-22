package engineeringthesis.androidrestapi.game.domain;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import engineeringthesis.androidrestapi.common.entity.AbstractUUIDEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldNameConstants;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
@Entity
@Table(name = "gameplay")
@FieldNameConstants
class Gameplay extends AbstractUUIDEntity {

    @OneToOne
    @JoinColumn(name = "language_id_fk")
    private GameplayLanguage language;

    @OneToOne
    @JoinColumn(name = "game_id_fk")
    private Game game;

    @OneToOne
    @JoinColumn(name = "category_id_fk")
    private GameplayCategory category;
	
	/*
	@OneToOne
	@JoinColumn(name = "child_id_fk")
	private ChildEntity childId;
	*/

    @Column(name = "starting_date")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @DateTimeFormat(pattern = "uuuu-MM-dd'T'HH:mm:ss.SSSX")
    private LocalDateTime startDate;

    @Column(name = "ending_date")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @DateTimeFormat(pattern = "uuuu-MM-dd'T'HH:mm:ss.SSSX")
    private LocalDateTime endDate;

    @Column(name = "quest_uuid_fk")
    private String questUUID;
}
