package ee.camping.back_camping.business.listings;

import ee.camping.back_camping.domain.listing.*;
import ee.camping.back_camping.domain.listing.image.Image;
import ee.camping.back_camping.domain.listing.image.ImageMapper;
import ee.camping.back_camping.domain.listing.image.ImageService;
import ee.camping.back_camping.domain.listing.location.Location;
import ee.camping.back_camping.domain.listing.location.LocationDto;
import ee.camping.back_camping.domain.listing.location.LocationMapper;
import ee.camping.back_camping.domain.listing.location.LocationService;
import ee.camping.back_camping.domain.review.ReviewService;
import ee.camping.back_camping.domain.review.ScoreInfo;
import ee.camping.back_camping.util.ImageUtil;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ListingsService {

    @Resource
    private ListingService listingService;
    @Resource
    private ImageService imageService;
    @Resource
    private ReviewService reviewService;
    @Resource
    private LocationService locationService;
    @Resource
    private ListingMapper listingMapper;
    @Resource
    private ImageMapper imageMapper;
    @Resource
    private LocationMapper locationMapper;


    public List<ListingPreviewDto> findMyListingsPreview(Integer userId) {
        List<Listing> myListings = listingService.findMyListings(userId);
        List<ListingPreviewDto> listingPreviewDtos = listingMapper.toListingPreviewDtos(myListings);
        addListingImages(listingPreviewDtos);
        addRatings(listingPreviewDtos);
        return listingPreviewDtos;
    }

    public List<AllListingsDto> findAllListings(Integer listingId) {
        List<Listing> allListings = listingService.findAllListings(listingId);
        List<AllListingsDto> allListingsDtos = listingMapper.toAllListingsDtos(allListings);
        addImagesForAllListings(allListingsDtos);
        addRatingsForAllListings(allListingsDtos);
//        addCountyForAllListings(allListingsDtos);
        addLocationForAllListings(allListingsDtos);

        return allListingsDtos;
    }

    private void addLocationForAllListings(List<AllListingsDto> allListingsDtos) {
        for (AllListingsDto allListingsDto : allListingsDtos) {
            Location location = locationService.findLocationBy(allListingsDto.getLocationId()).get();
            //LocationDto locationDto = locationMapper.toLocationDto(location);
            allListingsDto.setLocationDto(location);
        }
    }

    private void addListingImages(List<ListingPreviewDto> listingPreviewDtos) {
        for (ListingPreviewDto listingPreviewDto : listingPreviewDtos) {
            Image coverImage = imageService.findCoverImagesBy(listingPreviewDto.getListingId());
            String imageData = ImageUtil.byteArrayToBase64ImageData(coverImage.getData());
            listingPreviewDto.setImageData(imageData);
        }
    }

    private void addRatings(List<ListingPreviewDto> listingPreviewDtos) {
        for (ListingPreviewDto listingPreviewDto : listingPreviewDtos) {
            ScoreInfo scoreInfo = reviewService.findScoreInfo(listingPreviewDto.getListingId());
            listingPreviewDto.setNumberOfScores(scoreInfo.getNumberOfScores());
            listingPreviewDto.setAverageScore(Math.round(scoreInfo.getAverageScore() * 10.0) / 10.0);
        }
    }

    private void addImagesForAllListings(List<AllListingsDto> allListingsDtos) {
        for (AllListingsDto allListingsDto : allListingsDtos) {
            Image coverImage = imageService.findCoverImagesBy(allListingsDto.getListingId());
            String imageData = ImageUtil.byteArrayToBase64ImageData(coverImage.getData());
            allListingsDto.setImageData(imageData);
        }
    }

    private void addRatingsForAllListings(List<AllListingsDto> allListingsDtos) {
        for (AllListingsDto allListingsDto : allListingsDtos) {
            ScoreInfo scoreInfo = reviewService.findScoreInfo(allListingsDto.getListingId());
            allListingsDto.setNumberOfScores(scoreInfo.getNumberOfScores());
            allListingsDto.setAverageScore(scoreInfo.getAverageScore());
        }
    }
}
