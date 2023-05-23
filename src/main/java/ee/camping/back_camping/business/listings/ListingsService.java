package ee.camping.back_camping.business.listings;

import ee.camping.back_camping.domain.listing.ListingService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class ListingsService {

    @Resource
    private ListingService listingService;

    public void findMyListingsPreview(Integer userId) {
        listingService.findMyListingPreview(userId);
        
    }
}
