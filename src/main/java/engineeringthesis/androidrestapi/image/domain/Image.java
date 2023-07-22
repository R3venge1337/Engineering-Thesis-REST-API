package engineeringthesis.androidrestapi.image.domain;

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
@Table(name = "image")
@FieldNameConstants
class Image extends AbstractUUIDEntity {

    @Column(name = "download_uri")
    private String downloadUri;

    @Column(name = "is_new", columnDefinition = "BIT")
    private boolean isNew;

    @Column(name = "is_accepted", columnDefinition = "BIT")
    private boolean isAccepted;
	
	/*
	@OneToOne
	@JoinColumn(name = "word_id_fk")
	private WordEntity wordId;
	*/

    @OneToOne
    @JoinColumn(name = "ntfs_image_id_fk")
    //@Column(name = "ntfs_image_id_fk" , columnDefinition="uniqueidentifier")
    private ImageFileTable imageFileTable;
}
