package engineeringthesis.androidrestapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "statisticResults")
public class statisticResults {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "statisticResultsId")
	private Integer statisticResultsId;
	
	@Column(name = "statisticResults")
	private String statisticResults;
	
	@OneToOne
	@JoinColumn(name = "statisticId")
	private statistic statisticId;
	
	
	public statisticResults() {}

	public statisticResults(String statisticResults, statistic statisticId) {
		this.statisticResults = statisticResults;
		this.statisticId = statisticId;
	}
	
	

	public statisticResults(Integer statisticResultsId, String statisticResults, statistic statisticId) {
		this.statisticResultsId = statisticResultsId;
		this.statisticResults = statisticResults;
		this.statisticId = statisticId;
	}



	public Integer getStatisticResultsId() {
		return statisticResultsId;
	}

	public void setStatisticResultsId(Integer statisticResultsId) {
		this.statisticResultsId = statisticResultsId;
	}

	public String getStatisticResults() {
		return statisticResults;
	}

	public void setStatisticResults(String statisticResults) {
		this.statisticResults = statisticResults;
	}

	public statistic getStatisticId() {
		return statisticId;
	}

	public void setStatisticId(statistic statisticId) {
		this.statisticId = statisticId;
	}

	@Override
	public String toString() {
		return "statisticResults [statisticResultsId=" + statisticResultsId + ", statisticResults=" + statisticResults
				+ ", statisticId=" + statisticId + "]";
	}
	
	
	
	
}
