package ee.camping.back_camping.business.listings;

import ee.camping.back_camping.business.Status;
import ee.camping.back_camping.domain.listing.*;
import ee.camping.back_camping.domain.listing.image.Image;
import ee.camping.back_camping.domain.listing.image.ImageMapper;
import ee.camping.back_camping.domain.listing.image.ImageService;
import ee.camping.back_camping.domain.listing.location.*;
import ee.camping.back_camping.domain.review.ReviewService;
import ee.camping.back_camping.domain.review.ScoreInfo;
import ee.camping.back_camping.util.ImageUtil;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    private LocationService locationService;
    @Resource
    private CountyService countyService;
    @Resource
    private ListingMapper listingMapper;
    @Resource
    private ImageMapper imageMapper;
    @Resource
    private LocationMapper locationMapper;
    @Resource
    private CountyMapper countyMapper;


    public List<ListingPreviewDto> findMyListingsPreview(Integer userId) {
        List<Listing> myListings = listingService.findMyListings(userId);
        List<ListingPreviewDto> listingPreviewDtos = listingMapper.toListingPreviewDtos(myListings);
        addListingImages(listingPreviewDtos);
        addRatings(listingPreviewDtos);
        return listingPreviewDtos;
    }

    public List<ListingPreviewDto> findAllActiveListingsPreview() {
        List<Listing> allActiveListings = listingService.findAllActiveListings(Status.ACTIVE.getLetter());
        List<ListingPreviewDto> listingPreviewDtos = listingMapper.toListingPreviewDtos(allActiveListings);
        addListingImages(listingPreviewDtos);
        addRatings(listingPreviewDtos);
        return listingPreviewDtos;
    }

    public FullListingDto findListing(Integer listingId) {
        Listing listing = listingService.getListing(listingId);
        FullListingDto fullListingDto = listingMapper.toAllListingsDto(listing);
        setImageDatas(listingId, fullListingDto);
        setScoreinfo(listingId, fullListingDto);

        return fullListingDto;
    }

    private void setImageDatas(Integer listingId, FullListingDto fullListingDto) {
        List<Image> images = imageService.findListingImages(listingId);
        List<String> imageDatas = new ArrayList<>();
        for (Image image : images) {
            String imageData = ImageUtil.byteArrayToBase64ImageData(image.getData());
            imageDatas.add(imageData);
        }
        fullListingDto.setImageDatas(imageDatas);
    }
    private void setScoreinfo(Integer listingId, FullListingDto fullListingDto) {
        ScoreInfo scoreInfo = reviewService.findScoreInfo(listingId);
        fullListingDto.setNumberOfScores(scoreInfo.getNumberOfScores());
        fullListingDto.setAverageScore(scoreInfo.getAverageScore());
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
            if (scoreInfo.getAverageScore() == null) {
                listingPreviewDto.setAverageScore(0.0);
            } else {
                listingPreviewDto.setAverageScore(Math.round(scoreInfo.getAverageScore() * 10.0) / 10.0);
            }
        }
    }
}