package engineeringthesis.androidrestapi.audio.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "audio")
@Data
@NoArgsConstructor @AllArgsConstructor
@Builder
class Audio {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "audio_id_pk")
	private Integer audioId;
	
	//@Column(name = "ntfs_audio_id_fk" , columnDefinition="uniqueidentifier")
	//private String ntfsAudioFileId;
	
	@Column(name = "audio_download_uri")
	private String audioDownloadUri;
	
	/*
	@OneToOne
	@JoinColumn(name = "word_id_fk")
	private WordEntity wordId;
	*/
	
	@Column(name = "is_new", columnDefinition="BIT")
	private boolean isNew;
	
	@Column(name = "is_accepted", columnDefinition="BIT")
	private boolean isAccepted;
	
	@OneToOne
	@JoinColumn(name="ntfs_audio_id_fk")
	//@Column(name = "ntfs_image_id_fk" , columnDefinition="uniqueidentifier")
	private AudioFileTable audioFileTable;
	
}
