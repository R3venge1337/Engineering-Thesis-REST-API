package engineeringthesis.androidrestapi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "gameplay_result")
@Data
@NoArgsConstructor @AllArgsConstructor
@Builder
public class GameplayResultEntity {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "gameplay_result_id_pk")
	private Integer gameplayResultsId;
	
	@OneToOne
	@JoinColumn(name = "gameplay_id_fk")
	private GameplayEntity gameplayId;
	
	@OneToOne
	@JoinColumn(name = "statistic_result_id_fk")
	private StatisticResultEntity statisticResultsId;
	
}
