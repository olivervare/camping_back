package ee.camping.back_camping.domain.listing;

import ee.camping.back_camping.domain.review.RatingDto;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * A DTO for the {@link Listing} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListingPreviewDto implements Serializable {
    private Integer id;
    private String name;
    private Integer price;
    private String status;

    private List<ImageDto> imagesDto;
    private List<RatingDto> ratingsDto;
}