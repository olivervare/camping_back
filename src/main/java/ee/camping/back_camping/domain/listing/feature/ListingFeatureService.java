package ee.camping.back_camping.domain.listing.feature;

import ee.camping.back_camping.domain.listing.Listing;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ListingFeatureService {

    @Resource
    private ListingFeatureRepository listingFeatureRepository;


    public List<ListingFeature> findListingFeaturesBy(Integer listingId) {
        return listingFeatureRepository.findAllBy(listingId);
    }

    public void addAll(List<ListingFeature> listingFeatures) {
        listingFeatureRepository.saveAll(listingFeatures);
    }

    public List<ListingFeature> getListingIdBy(Integer featureId, Boolean isSelected) {
        return listingFeatureRepository.getListingId(featureId, isSelected);
    }

    public ListingFeature getFeatureBy(Integer featureId, Boolean featureIsSelected) {
        return listingFeatureRepository.getFeatureBy(featureId, featureIsSelected);
    }

    public void deleteAllBy(Listing listing) {
        listingFeatureRepository.deleteAllBy(listing);
    }
}

