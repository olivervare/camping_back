package ee.camping.back_camping.business.listings;

import ee.camping.back_camping.domain.listing.*;
import ee.camping.back_camping.domain.review.Review;
import ee.camping.back_camping.domain.review.ReviewService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListingsService {

    @Resource
    private ListingService listingService;
    @Resource
    private ImageService imageService;
    @Resource
    private ReviewService reviewService;
    @Resource
    private ListingMapper listingMapper;

    public List<ListingPreviewDto> findMyListingsPreview(Integer userId) {
        List<Listing> myListings = listingService.findMyListings(userId);
        List<ListingPreviewDto> listingPreviewDto = listingMapper.toListingPreviewDto(myListings);

        List<Image> listingImages = imageService.findListingImages(userId);

        List<Review> listingReviews = reviewService.getListingRating(userId);
        return listingPreviewDto;
    }
}
