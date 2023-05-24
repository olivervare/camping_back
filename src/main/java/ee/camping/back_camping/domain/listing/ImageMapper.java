package ee.camping.back_camping.domain.listing;

import ee.camping.back_camping.util.ImageUtil;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ImageMapper {

    @Mapping(source = "data", target = "imageData", qualifiedByName = "dataToImageData")
    ImageDto toImageDto(Image image);

    List<ImageDto> toImagesDto(List<Image> listingImages);

    @Named("dataToImageData")
    static String dataToImageData(byte[] data) {
        if (data == null) {
            return "";
        }
        return ImageUtil.byteArrayToBase64ImageData(data);
    }
}