package ee.camping.back_camping.domain.listing;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageService {

    @Resource
    private ImageRepository imageRepository;

    public List<Image> findListingImages(Integer userId) {
        return imageRepository.findListingImagesByUser(userId);
    }
}
