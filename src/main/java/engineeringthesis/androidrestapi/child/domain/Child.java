package engineeringthesis.androidrestapi.child.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "child")
@Data
@NoArgsConstructor @AllArgsConstructor
@Builder
class Child {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "child_id_pk")
	private Integer childId;
	
	@Column(name = "child_name")
	private String childName;
	
	@Column(name = "child_surname")
	private String childSurname;
	
	@Column(name = "child_year_of_birth")
	private Short childYearBirth;
	
	@Column(name = "child_city")
	private String childCity;
	
	@Column(name = "child_quest_uuid")
	private String childQuestUUID;
	
    @OneToOne
    @JoinColumn(name = "account_id_fk",nullable = false)
    Account accountChildId;
	
}
