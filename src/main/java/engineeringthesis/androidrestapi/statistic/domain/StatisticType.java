package engineeringthesis.androidrestapi.statistic.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "statistic")
@Data
@NoArgsConstructor @AllArgsConstructor
@Builder
class StatisticType {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "statistic_id_pk")
	private Integer statisticId;
	
	@Column(name = "statistic_name")
	private String statisticName;
	
}
