package engineeringthesis.androidrestapi.account.domain;

import java.time.LocalDateTime;

import engineeringthesis.androidrestapi.common.entity.AbstractUUIDEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldNameConstants;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
@Entity
@Table(name = "account")
@FieldNameConstants
class Account extends AbstractUUIDEntity {

	@Column(name = "name")
	private String name;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "date_created")
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)  
	@JsonSerialize(using = LocalDateTimeSerializer.class)  
	@DateTimeFormat(pattern = "uuuu-MM-dd'T'HH:mm:ss.SSSX")
	private LocalDateTime createdDate;
	
	@Column(name = "email")
	private String email;

	@Column(name = "is_active")
	private Boolean isActive;
	
	@ManyToOne
	@JoinColumn(name = "role_id_fk")
	private AccountRole role;
}
