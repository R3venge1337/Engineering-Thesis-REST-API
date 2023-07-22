package engineeringthesis.androidrestapi.word.domain;

import engineeringthesis.androidrestapi.common.entity.AbstractUUIDEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
@Table(name = "word")
@FieldNameConstants
class Word extends AbstractUUIDEntity {


    @Column(name = "name")
    private String name;

    @Column(name = "download_uri")
    private String downloadUri;

    @OneToOne
    @JoinColumn(name = "category_id_fk")
    private WordCategory category;

    @OneToOne
    @JoinColumn(name = "language_id_fk")
    private WordLanguage language;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "image_id_fk", referencedColumnName = "id")
    private WordImage image;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "audio_id_fk", referencedColumnName = "id")
    private WordAudio audio;
}
