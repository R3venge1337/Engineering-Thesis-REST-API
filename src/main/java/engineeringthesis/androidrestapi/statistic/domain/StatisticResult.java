package engineeringthesis.androidrestapi.statistic.domain;

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


@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
@Entity
@Table(name = "statisticResult")
@FieldNameConstants
class StatisticResult extends AbstractUUIDEntity {

    @Column(name = "statistic_result")
    private String result;

    @OneToOne
    @JoinColumn(name = "statistic_id_fk")
    private StatisticType statistic;
}
