package ee.camping.back_camping.domain.listing;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
public class ListingPreviewDto implements Serializable {
    private Integer id;
    private String name;
    private String status;
}