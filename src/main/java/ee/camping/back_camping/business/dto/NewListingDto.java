package ee.camping.back_camping.business.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link ee.camping.back_camping.domain.listing.Listing} entity
 */
@Data
public class NewListingDto implements Serializable {
    private  Integer ownerUserId;

    private  String listingName;
}