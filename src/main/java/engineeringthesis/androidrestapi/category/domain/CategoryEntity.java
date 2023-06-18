package engineeringthesis.androidrestapi.category.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import engineeringthesis.androidrestapi.language.domain.LanguageEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "category")
@Data
@NoArgsConstructor @AllArgsConstructor
@Builder
class CategoryEntity {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id_pk")
	private Integer categoryId;
	
	@Column(name = "category_name")
	private String categoryName;
	
	@OneToOne
	@JoinColumn(name = "language_id_fk")
	private LanguageEntity languageId;
	
	@Column(name = "is_new", columnDefinition="BIT")
	private boolean isNew;
	
	@Column(name = "is_accepted", columnDefinition="BIT")
	private boolean isAccepted;
	
}
