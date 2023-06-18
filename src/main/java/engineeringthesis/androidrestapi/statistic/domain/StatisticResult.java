package engineeringthesis.androidrestapi.statistic.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Table(name = "statisticResult")
@Data
@NoArgsConstructor @AllArgsConstructor
@Builder
class StatisticResult {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "statistic_result_id_pk")
	private Integer statisticResultsId;
	
	@Column(name = "statistic_result_score")
	private String statisticResults;
	
	@OneToOne
	@JoinColumn(name = "statistic_id_fk")
	private StatisticType statisticId;
}
