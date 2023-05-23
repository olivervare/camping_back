package ee.camping.back_camping.domain.listing;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ListingService {
    private final ListingRepository listingRepository;

    public ListingService(ListingRepository listingRepository) {
        this.listingRepository = listingRepository;
    }

    public Optional<Listing> findMyListingPreview(Integer userId) {
        return listingRepository.findListingBy(userId);
    }
}
