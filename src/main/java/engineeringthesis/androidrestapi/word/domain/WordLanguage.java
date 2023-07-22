package engineeringthesis.androidrestapi.word.domain;

import engineeringthesis.androidrestapi.common.entity.AbstractUUIDEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldNameConstants;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
@Entity
@Table(name = "language")
@FieldNameConstants
class WordLanguage extends AbstractUUIDEntity {

    @Column(name = "name")
    private String name;
}
