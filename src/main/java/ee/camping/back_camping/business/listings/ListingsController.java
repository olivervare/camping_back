package ee.camping.back_camping.business.listings;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ListingsController {
    @Resource
    private ListingsService listingsService;

    @GetMapping("/my-listings")
    @Operation(summary = "Tagastab userId järgi kasutaja telkimisplatsi nime, pildi ja reitingu")
    public List<ListingPreviewDto> findMyListingsPreview(@RequestParam Integer userId) {
        return listingsService.findMyListingsPreview(userId);
    }

    @GetMapping("/all-listings")
    @Operation(summary = "Tagastab listingId järgi kõikide telkimisplatside andmed",
            description = "Kuvab listingu kõik pildid, nime (listing name), ja reitingu (average score)")
    public List<AllListingsDto> findAllListings(@RequestParam Integer listingId) {
        return listingsService.findAllListings(listingId);
    }
}
