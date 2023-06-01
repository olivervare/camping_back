package ee.camping.back_camping.domain.booking;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * A DTO for the {@link Booking} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingDto implements Serializable {
    private Integer id;
    private Integer customerUserId;
    private Integer listingId;
    private Integer peopleCount;
    private LocalDate checkIn;
    private LocalDate checkOut;
    private String status;
}