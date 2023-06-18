package engineeringthesis.androidrestapi.image.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "image")
@Data
@NoArgsConstructor @AllArgsConstructor
@Builder
class Image {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "image_id_pk")
	private Integer imageId;
	
	@Column(name = "image_download_uri")
	private String imageDownloadUri;
	
	@Column(name = "is_new", columnDefinition="BIT")
	private boolean isNew;
	
	@Column(name = "is_accepted", columnDefinition="BIT")
	private boolean isAccepted;
	
	/*
	@OneToOne
	@JoinColumn(name = "word_id_fk")
	private WordEntity wordId;
	*/
	
	@OneToOne
	@JoinColumn(name="ntfs_image_id_fk")
	//@Column(name = "ntfs_image_id_fk" , columnDefinition="uniqueidentifier")
	private ImageFileTable imageFileTable;
	
	
	
}
