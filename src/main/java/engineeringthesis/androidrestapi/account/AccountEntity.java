package engineeringthesis.androidrestapi.account;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

import engineeringthesis.androidrestapi.role.RoleEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "account")
@Data
@NoArgsConstructor @AllArgsConstructor
@Builder
public class AccountEntity{
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id_pk")
	private Integer accountId;
	
	@Column(name = "account_name")
	private String accountName;
	
	@Column(name = "account_password")
	private String accountPassword;
	
	@Column(name = "account_date_created")
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)  
	@JsonSerialize(using = LocalDateTimeSerializer.class)  
	@DateTimeFormat(pattern = "uuuu-MM-dd'T'HH:mm:ss.SSSX")
	private LocalDateTime accountCreatedDate;
	
	@Column(name = "account_email")
	private String accountEmail;
	
	@ManyToOne
	@JoinColumn(name = "role_id_fk")
	RoleEntity role;
	
	
}
