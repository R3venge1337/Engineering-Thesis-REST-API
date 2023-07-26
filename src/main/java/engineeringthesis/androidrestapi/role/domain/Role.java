package engineeringthesis.androidrestapi.role.domain;

import engineeringthesis.androidrestapi.common.entity.AbstractUUIDEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldNameConstants;

import java.time.LocalDateTime;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
@Entity
@Table(name = "role")
@FieldNameConstants
class Role extends AbstractUUIDEntity {

    @Column(name = "name")
    private String name;


    @Column(name = "date_created")
    private LocalDateTime createdDate;
}
