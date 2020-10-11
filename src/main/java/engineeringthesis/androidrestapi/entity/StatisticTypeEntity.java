package engineeringthesis.androidrestapi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Table(name = "statistic")
@Data
@NoArgsConstructor @AllArgsConstructor
@Builder
public class StatisticTypeEntity {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "statistic_id_pk")
	private Integer statisticId;
	
	@Column(name = "statistic_name")
	private String statisticName;
	
}
