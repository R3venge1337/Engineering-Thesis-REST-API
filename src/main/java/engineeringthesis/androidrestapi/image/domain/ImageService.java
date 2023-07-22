package engineeringthesis.androidrestapi.image.domain;

import engineeringthesis.androidrestapi.common.entity.ReaderPropertiesFile;
import engineeringthesis.androidrestapi.common.exception.FileNotFoundException;
import engineeringthesis.androidrestapi.common.exception.NotFoundException;
import engineeringthesis.androidrestapi.image.ImageFacade;
import engineeringthesis.androidrestapi.image.dto.ImageDto;
import engineeringthesis.androidrestapi.image.dto.UpdateImageForm;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Properties;
import java.util.UUID;

@RequiredArgsConstructor
class ImageService implements ImageFacade {

    private final ImageRepository imageReposiitory;
    private final ReaderPropertiesFile readerPropertiesFile;
    private final ImageFileTableRepository imageFileTableRepository;

    @Override
    public List<ImageDto> getAllImages() {
        return imageReposiitory.findAll().stream()
                .map(this::mapToDto)
                .toList();
    }

    @Override
    public ImageDto saveImage(final MultipartFile file) {
        Properties prop;
        try {
            prop = readerPropertiesFile.readPropertiesFile("application.properties");
            Path path = Paths.get(prop.getProperty("image_save_files_path"));
            //System.out.println(path.resolve(file.getOriginalFilename()));
            Files.write(path.resolve(file.getOriginalFilename()), file.getBytes());

        } catch (Exception e) {
            throw new RuntimeException("Could not store the file. Error: " + e.getMessage());
        }
        ImageFileTable imgId = imageFileTableRepository.findByName(file.getOriginalFilename());
        String streamId = imgId.getStreamId();
        System.out.println(streamId);

        String fileDownloadUri = prop.getProperty("image_download_uri") + file.getOriginalFilename();
        System.out.println(fileDownloadUri);

        //WordEntity word = wordRepository.findById(wordid);

        Image imageObj = new Image();
        imageObj.setImageFileTable(imgId);
        imageObj.setDownloadUri(fileDownloadUri);
        imageObj.setAccepted(false);
        imageObj.setNew(true);

        return mapToDto(imageReposiitory.save(imageObj));
    }

    public ImageDto findImage(final UUID uuid) {
        return imageReposiitory.findByUuid(uuid)
                .map(this::mapToDto)
                .orElseThrow(() -> new NotFoundException(""));
    }

    @Override
    @Transactional
    public void updateImage(final UUID uuid, final UpdateImageForm imageForm) {
        Image image = imageReposiitory.findByUuid(uuid)
                .orElseThrow(() -> new NotFoundException(""));
    }

    @Override
    @Transactional
    public void deleteImage(final UUID uuid) {
        imageReposiitory.deleteByUuid(uuid);
    }

    @Override
    public Resource loadImageAsResource(final String imageName) {

        try {
            Properties prop = null;
            try {
                prop = readerPropertiesFile.readPropertiesFile("application.properties");
            } catch (IOException e) {
                e.printStackTrace();
            }
            Path path = Paths.get(prop.getProperty("image_save_files_path"));
            Resource resource = new UrlResource(path.toUri() + imageName);
            if (resource.exists()) {
                return resource;
            } else {
                throw new FileNotFoundException("File not found " + imageName);
            }
        } catch (MalformedURLException ex) {
            throw new FileNotFoundException("File not found " + imageName, ex);
        }
    }

    ImageDto mapToDto(final Image image) {
        return new ImageDto(image.getDownloadUri());
    }
}
