package ee.camping.back_camping.domain.listing.location;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * A DTO for the {@link Location} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LocationDto implements Serializable {
    private Integer countyId;
    @Size(max = 255)
    @NotNull
    private String address;
    @NotNull
    private BigDecimal longitude;
    @NotNull
    private BigDecimal latitude;
}