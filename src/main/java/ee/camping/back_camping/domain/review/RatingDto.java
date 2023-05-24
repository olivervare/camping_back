package ee.camping.back_camping.domain.review;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * A DTO for the {@link Review} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RatingDto implements Serializable {
    @NotNull
    private Integer rating;
}