package engineeringthesis.androidrestapi.mapper;

import org.springframework.stereotype.Component;

import engineeringthesis.androidrestapi.dto.ImageDTO;
import engineeringthesis.androidrestapi.entity.ImageEntity;
@Component
public class ImageMapper implements Mapper<ImageDTO,ImageEntity> {

	@Override
	public ImageDTO mapOfEntity(ImageEntity entity) {
		
		ImageDTO imageDTO = ImageDTO.builder()
				.imageDownloadUri(entity.getImageDownloadUri())
				.wordId(entity.getWordId())
				.imageFileTable(entity.getImageFileTable())
				.isAccepted(entity.isAccepted())
				.isNew(entity.isNew())
				.build();
		
		return imageDTO;
	}

	@Override
	public ImageEntity mapOfDTO(ImageDTO dto) {
		
		ImageEntity imageEntity = ImageEntity.builder()
				.imageDownloadUri(dto.getImageDownloadUri())
				.wordId(dto.getWordId())
				.imageFileTable(dto.getImageFileTable())
				.isAccepted(dto.isAccepted())
				.isNew(dto.isNew())
				.build();
		
		return imageEntity;
	}

}
