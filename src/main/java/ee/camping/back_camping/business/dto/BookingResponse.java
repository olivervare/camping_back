package ee.camping.back_camping.business.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * A DTO for the {@link ee.camping.back_camping.domain.booking.Booking} entity
 */
@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingResponse implements Serializable {
    private Integer bookingId;
}
