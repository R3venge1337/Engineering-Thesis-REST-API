package engineeringthesis.androidrestapi.image;

import org.springframework.stereotype.Component;

import engineeringthesis.androidrestapi.util.Mapper;
@Component
public class ImageMapper implements Mapper<ImageDTO,ImageEntity> {

	@Override
	public ImageDTO mapOfEntity(ImageEntity entity) {
		
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
	public ImageEntity mapOfDTO(ImageDTO dto) {
		
		ImageEntity imageEntity = ImageEntity.builder()
				.imageId(dto.getImageId())
				.imageDownloadUri(dto.getImageDownloadUri())
				.imageFileTable(dto.getImageFileTable())
				.isAccepted(dto.isAccepted())
				.isNew(dto.isNew())
				.build();
		
		return imageEntity;
	}

}
