package ee.camping.back_camping.business.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link ee.camping.back_camping.domain.listing.Listing} entity
 */
@Data
public class AddListingResponseDto implements Serializable {
    private Integer listingId;

}