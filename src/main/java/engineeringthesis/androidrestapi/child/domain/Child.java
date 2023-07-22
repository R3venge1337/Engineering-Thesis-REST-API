package engineeringthesis.androidrestapi.child.domain;

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
@Table(name = "child")
@FieldNameConstants
class Child extends AbstractUUIDEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "year_of_birth")
    private Short yearOfBirth;

    @Column(name = "city")
    private String city;

    @Column(name = "quest_uuid")
    private String questUUID;

    @OneToOne
    @JoinColumn(name = "account_id_fk", nullable = false)
    ChildAccount accountChild;
}
