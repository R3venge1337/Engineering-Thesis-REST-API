package engineeringthesis.androidrestapi.game.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import engineeringthesis.androidrestapi.statistic.domain.StatisticResult;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "gameplay_result")
@Data
@NoArgsConstructor @AllArgsConstructor
@Builder
class GameplayResult {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "gameplay_result_id_pk")
	private Integer gameplayResultsId;
	
	@OneToOne
	@JoinColumn(name = "gameplay_id_fk")
	private Gameplay gameplayId;
	
	@OneToOne
	@JoinColumn(name = "statistic_result_id_fk")
	private StatisticResult statisticResultsId;
	
}