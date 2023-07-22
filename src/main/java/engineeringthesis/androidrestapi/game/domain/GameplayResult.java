package engineeringthesis.androidrestapi.game.domain;

import engineeringthesis.androidrestapi.common.entity.AbstractUUIDEntity;
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
@Table(name = "gameplay_result")
@FieldNameConstants
class GameplayResult extends AbstractUUIDEntity {

    @OneToOne
    @JoinColumn(name = "gameplay_id_fk")
    private Gameplay gameplay;

    @OneToOne
    @JoinColumn(name = "statistic_result_id_fk")
    private GameplayResultStatisticResult statisticResults;
}
