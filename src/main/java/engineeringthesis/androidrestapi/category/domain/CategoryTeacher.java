package engineeringthesis.androidrestapi.category.domain;


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
@Table(name = "category_teacher")
@FieldNameConstants
class CategoryTeacher extends AbstractUUIDEntity {

    @OneToOne
    @JoinColumn(name = "category_id_fk")
    private Category category;

    @OneToOne
    @JoinColumn(name = "teacher_id_fk")
    private TeacherCategory teacher;

    @Column(name = "is_new", columnDefinition = "BIT")
    private Boolean isNew;

    @Column(name = "is_accepted", columnDefinition = "BIT")
    private Boolean isAccepted;
}
