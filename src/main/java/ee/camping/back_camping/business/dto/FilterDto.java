package ee.camping.back_camping.business.dto;

import ee.camping.back_camping.domain.listing.Listing;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * A DTO for the {@link Listing} entity
 */
@Data
public class FilterDto implements Serializable {
    private Integer locationCountyId;
    private List<FeatureDto> features;
}
