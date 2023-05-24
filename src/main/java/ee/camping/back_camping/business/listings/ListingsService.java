package ee.camping.back_camping.business.listings;

import ee.camping.back_camping.domain.listing.*;
import ee.camping.back_camping.domain.review.RatingDto;
import ee.camping.back_camping.domain.review.Review;
import ee.camping.back_camping.domain.review.ReviewMapper;
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
    @Resource
    private ImageMapper imageMapper;
    @Resource
    private ReviewMapper reviewMapper;

    public List<ListingPreviewDto> findMyListingsPreview(Integer userId) {
        List<Listing> myListings = listingService.findMyListings(userId);
        List<ListingPreviewDto> listingPreviewsDto = listingMapper.toListingPreviewsDto(myListings);
        addListingImages(listingPreviewsDto);
        addListingReviews(listingPreviewsDto);

        return listingPreviewsDto;
    }

    private void addListingImages(List<ListingPreviewDto> listingPreviewsDto) {
        for (ListingPreviewDto listingPreviewDto : listingPreviewsDto) {
            List<Image> listingImages = getListingImages(listingPreviewDto.getId());
            List<ImageDto> imagesDto = mapToImages(listingImages);
            listingPreviewDto.setImagesDto(imagesDto);


        }
    }
    private void addListingReviews(List<ListingPreviewDto> listingPreviewsDto) {
        for (ListingPreviewDto listingPreviewDto : listingPreviewsDto) {
            List<Review> listingReviews = findListingReview(listingPreviewDto.getId());
            List<RatingDto> ratingsDto = mapToRatings(listingReviews);
            listingPreviewDto.setRatingsDto(ratingsDto);

        }
    }

    private List<Image> getListingImages(Integer id) {
        return imageService.getListingImagesBy(id);
    }

    private List<ImageDto> mapToImages(List<Image> listingImages) {
        return imageMapper.toImagesDto(listingImages);
    }

    private List<Review> findListingReview(Integer id) {
        return reviewService.findListingReviewsBy(id);
    }

    private List<RatingDto> mapToRatings(List<Review> listingReviews) {
        return reviewMapper.toRatingsDto(listingReviews);
    }
}
