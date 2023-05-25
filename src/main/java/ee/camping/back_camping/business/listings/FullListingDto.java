package ee.camping.back_camping.business.listings;

import ee.camping.back_camping.domain.listing.Listing;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * A DTO for the {@link Listing} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FullListingDto implements Serializable {
//    private Integer ListingId;
    private String listingName;
    private String listingDescription;
    private String listingAdditionalInfo;
    private Integer price;
    private Integer countyId;
    private String countyName;
    private Integer locationId;
    private String locationAddress;
    private BigDecimal locationLongitude;
    private BigDecimal locationLatitude;
    private List <String> imageDatas;
    private Long numberOfScores;
    private Double averageScore;
}