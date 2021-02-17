package engineeringthesis.androidrestapi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name = "word")
@Data
@NoArgsConstructor @AllArgsConstructor
@Builder
public class WordEntity {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "word_id_pk ")
	private Integer wordId;
	
	@Column(name = "word_name")
	private String wordName;
	
	@Column(name = "word_download_uri")
	private String wordDownloadUri;
	
	@OneToOne
	@JoinColumn(name = "category_id_fk")
	private CategoryEntity categoryId;
	
	@OneToOne
	@JoinColumn(name = "language_id_fk")
	private LanguageEntity languageId;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "image_id_fk",referencedColumnName = "image_id_pk")
	private ImageEntity imageId;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "audio_id_fk",referencedColumnName = "audio_id_pk")
	private AudioEntity audioId;
	
	
	
}
