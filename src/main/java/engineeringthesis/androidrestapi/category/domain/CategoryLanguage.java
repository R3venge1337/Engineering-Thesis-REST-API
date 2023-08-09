package engineeringthesis.androidrestapi.category.domain;

import engineeringthesis.androidrestapi.common.entity.AbstractUUIDEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldNameConstants;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
@Entity
@Table(name = "language")
@FieldNameConstants
class CategoryLanguage extends AbstractUUIDEntity {

    @Column(name = "name")
    private String name;


    //@Column(name = "language_icon")
    //private String languageImageIcon;

    @Column(name = "date_created")
    @DateTimeFormat(pattern = "uuuu-MM-dd'T'HH:mm:ss.SSSX")
    private LocalDateTime createdDate;
}