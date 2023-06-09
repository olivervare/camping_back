package ee.camping.back_camping.business.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * A DTO for the {@link ee.camping.back_camping.domain.booking.Booking} entity
 */
@Data
@Component
@AllArgsConstructor
@NoArgsConstructor
public class BookingDto implements Serializable {
    private Integer bookingId;
    private Integer customerUserId;
    private String customerUserName;
    private Integer listingId;
    private Integer ownerUserId;
    private String listingName;
    private Integer listingPrice;
    private Integer peopleCount;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private String bookingStatus;
}
