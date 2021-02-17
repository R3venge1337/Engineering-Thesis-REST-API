package engineeringthesis.androidrestapi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "category_teacher")
@Data
@NoArgsConstructor @AllArgsConstructor
@Builder
public class CategoryTeacherEntity {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_teacher_id_pk")
	private Integer categoryTeacherId;
	
	@OneToOne
	@JoinColumn(name = "category_id_fk")
	private CategoryEntity categoryId;
	
	@OneToOne
	@JoinColumn(name = "teacher_id_fk")
	private TeacherEntity teacherId;
	
	@Column(name = "is_new", columnDefinition="BIT")
	private boolean isNew;
	
	@Column(name = "is_accepted", columnDefinition="BIT")
	private boolean isAccepted;
}
