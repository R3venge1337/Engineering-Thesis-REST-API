package engineeringthesis.androidrestapi.audio.domain;

import engineeringthesis.androidrestapi.common.entity.AbstractUUIDEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldNameConstants;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
@Entity
@Table(name = "audio")
@FieldNameConstants
class Audio extends AbstractUUIDEntity {

	//@Column(name = "ntfs_audio_id_fk" , columnDefinition="uniqueidentifier")
	//private String ntfsAudioFileId;
	
	@Column(name = "download_uri")
	private String downloadUri;
	
	/*
	@OneToOne
	@JoinColumn(name = "word_id_fk")
	private Word word;
	*/
	
	@Column(name = "is_new", columnDefinition="BIT")
	private Boolean isNew;
	
	@Column(name = "is_accepted", columnDefinition="BIT")
	private Boolean isAccepted;
	
	@OneToOne
	@JoinColumn(name="ntfs_audio_id_fk")
	//@Column(name = "ntfs_image_id_fk" , columnDefinition="uniqueidentifier")
	private AudioFileTable audioFileTable;
	
}
