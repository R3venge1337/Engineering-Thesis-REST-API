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
@Table(name = "audio")
@Data
@NoArgsConstructor @AllArgsConstructor
@Builder
public class AudioEntity {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "audio_id_pk")
	private Integer audioId;
	
	@Column(name = "ntfs_audio_id_fk" , columnDefinition="uniqueidentifier")
	private String ntfsAudioFileId;
	
	@Column(name = "audio_download_uri")
	private String audioDownloadUri;
	
	@OneToOne
	@JoinColumn(name = "word_id_fk")
	private WordEntity wordId;
	
	@Column(name = "is_new", columnDefinition="BIT")
	private boolean isNew;
	
	@Column(name = "is_accepted", columnDefinition="BIT")
	private boolean isAccepted;
	
}
