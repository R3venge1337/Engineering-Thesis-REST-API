package engineeringthesis.androidrestapi.teacher.domain;


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
@Table(name = "teacher")
@FieldNameConstants
class Teacher extends AbstractUUIDEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "year_of_birth")
    private Short yearOfBirth;

    @Column(name = "city")
    private String city;

    @Column(name = "profession")
    private String profession;

    @OneToOne
    @JoinColumn(name = "language_id_fk")
    private TeacherLanguage languageTeacher;

    @OneToOne
    @JoinColumn(name = "account_id_fk")
    private TeacherAccount accountTeacher;
}
