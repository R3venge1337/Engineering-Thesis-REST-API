package engineeringthesis.androidrestapi.category.domain;



import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "category_teacher")
@Data
@NoArgsConstructor @AllArgsConstructor
@Builder
class CategoryTeacher {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_teacher_id_pk")
	private Integer categoryTeacherId;
	
	@OneToOne
	@JoinColumn(name = "category_id_fk")
	private Category categoryId;
	
	@OneToOne
	@JoinColumn(name = "teacher_id_fk")
	private Teacher teacherId;
	
	@Column(name = "is_new", columnDefinition="BIT")
	private boolean isNew;
	
	@Column(name = "is_accepted", columnDefinition="BIT")
	private boolean isAccepted;
}
