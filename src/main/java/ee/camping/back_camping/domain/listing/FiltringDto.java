package ee.camping.back_camping.domain.listing;

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
public class FiltringDto implements Serializable {
    private Integer locationCountyId;
}