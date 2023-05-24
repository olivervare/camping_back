package ee.camping.back_camping.domain.listing;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListingService {
    private final ListingRepository listingRepository;

    public ListingService(ListingRepository listingRepository) {
        this.listingRepository = listingRepository;
    }

    public List<Listing> findMyListings(Integer userId) {
        return listingRepository.findListingsBy(userId);
    }
}
