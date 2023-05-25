package ee.camping.back_camping.domain.listing;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListingService {

    @Resource
    private ListingRepository listingRepository;


    public List<Listing> findMyListings(Integer userId) {
        return listingRepository.findListingsBy(userId);
    }

    public Listing getListing(Integer listingId) {
        return listingRepository.getListingBy(listingId);
    }

    public List<Listing> findAllActiveListings(String status) {
        return listingRepository.findAllActiveListings(status);
    }

}
