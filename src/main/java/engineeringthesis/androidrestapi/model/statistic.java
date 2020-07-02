package engineeringthesis.androidrestapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "statistic")
public class statistic {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "statisticId")
	private Integer statisticId;
	
	@Column(name = "statisticName")
	private String statisticName;
	
	public statistic() {}
	

	public statistic(String statisticName) {
		this.statisticName = statisticName;
	}


	public statistic(Integer statisticId, String statisticName) {
		this.statisticId = statisticId;
		this.statisticName = statisticName;
	}

	public Integer getStatisticId() {
		return statisticId;
	}

	public void setStatisticId(Integer statisticId) {
		this.statisticId = statisticId;
	}

	public String getStatisticName() {
		return statisticName;
	}

	public void setStatisticName(String statisticName) {
		this.statisticName = statisticName;
	}


	@Override
	public String toString() {
		return "statistic [statisticId=" + statisticId + ", statisticName=" + statisticName + "]";
	}
	
	
	
	
}
