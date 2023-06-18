package engineeringthesis.androidrestapi.word.domain;

import engineeringthesis.androidrestapi.audio.AudioEntity;
import engineeringthesis.androidrestapi.category.domain.CategoryEntity;
import engineeringthesis.androidrestapi.image.domain.ImageEntity;
import engineeringthesis.androidrestapi.language.domain.LanguageEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "word")
@Data
@NoArgsConstructor @AllArgsConstructor
@Builder
class Word {
	
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
	private Category categoryId;
	
	@OneToOne
	@JoinColumn(name = "language_id_fk")
	private Language languageId;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "image_id_fk",referencedColumnName = "image_id_pk")
	private Image imageId;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "audio_id_fk",referencedColumnName = "audio_id_pk")
	private Audio audioId;
}
