package engineeringthesis.androidrestapi.category.domain;

import engineeringthesis.androidrestapi.common.entity.AbstractUUIDEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldNameConstants;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
@Entity
@Table(name = "category")
@FieldNameConstants
class Category extends AbstractUUIDEntity {

	@Column(name = "name")
	private String name;

	@Column(name = "is_new")
	private Boolean isNew;
	
	@Column(name = "is_accepted")
	private Boolean isAccepted;

	@OneToOne
	@JoinColumn(name = "language_id_fk")
	private CategoryLanguage language;
}
