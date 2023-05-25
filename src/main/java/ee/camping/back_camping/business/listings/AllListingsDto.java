package ee.camping.back_camping.business.listings;

import ee.camping.back_camping.domain.listing.Listing;
import ee.camping.back_camping.domain.listing.location.Location;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * A DTO for the {@link Listing} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AllListingsDto implements Serializable {
    private Integer ListingId;
    private String ListingName;
    private String listingDescription;
    private String listingAdditionalInfo;
    private Integer price;
    private String locationCountyName;
    private Integer locationId;
    private Location locationDto;

    private String imageData;
    private Long numberOfScores;
    private Double averageScore;
}