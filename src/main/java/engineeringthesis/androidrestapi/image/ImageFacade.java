package engineeringthesis.androidrestapi.image;

import engineeringthesis.androidrestapi.common.controller.PageDto;
import engineeringthesis.androidrestapi.common.controller.PageableRequest;
import engineeringthesis.androidrestapi.common.controller.UuidDto;
import engineeringthesis.androidrestapi.image.dto.ImageDto;
import engineeringthesis.androidrestapi.image.dto.ImageFilterForm;
import engineeringthesis.androidrestapi.image.dto.UpdateImageForm;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

public interface ImageFacade {


    PageDto<ImageDto> findImages(final ImageFilterForm filterForm, final PageableRequest pageableRequest);

    UuidDto saveImage(final MultipartFile file);

    ImageDto findImage(final UUID uuid);

    void updateImage(final UUID uuid, final UpdateImageForm imageForm);

    Resource loadImageAsResource(final String imageName);

    void deleteImage(final UUID uuid);
}
