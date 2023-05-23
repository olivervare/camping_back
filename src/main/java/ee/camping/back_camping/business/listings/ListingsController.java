package ee.camping.back_camping.business.listings;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ListingsController {
    @Resource
    private ListingsService listingsService;

    @GetMapping("/my-listings")
    @Operation(summary = "Tagastab userId järgi kasutaja pakutud telkimisplatsi nime, pildi ja reitingu")
    public void findMyListingsPreview(@RequestParam Integer userId) {
        listingsService.findMyListingsPreview(userId);
    }
}
