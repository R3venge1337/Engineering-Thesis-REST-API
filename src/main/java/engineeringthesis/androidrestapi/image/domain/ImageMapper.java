package engineeringthesis.androidrestapi.image.domain;

import engineeringthesis.androidrestapi.image.dto.ImageDTO;
import org.springframework.stereotype.Component;

import engineeringthesis.androidrestapi.common.entity.Mapper;
@Component
class ImageMapper implements Mapper<ImageDTO, Image> {

	@Override
	public ImageDTO mapOfEntity(Image entity) {
		
		ImageDTO imageDTO = ImageDTO.builder()
				.imageId(entity.getImageId())
				.imageDownloadUri(entity.getImageDownloadUri())
				.imageFileTable(entity.getImageFileTable())
				.isAccepted(entity.isAccepted())
				.isNew(entity.isNew())
				.build();
		
		return imageDTO;
	}

	@Override
	public Image mapOfDTO(ImageDTO dto) {
		
		Image imageEntity = Image.builder()
				.imageId(dto.getImageId())
				.imageDownloadUri(dto.getImageDownloadUri())
				.imageFileTable(dto.getImageFileTable())
				.isAccepted(dto.isAccepted())
				.isNew(dto.isNew())
				.build();
		
		return imageEntity;
	}

}
