package ee.camping.back_camping.business.dto;

import ee.camping.back_camping.domain.booking.Booking;
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
public class NewBookingDto implements Serializable {
    private Integer id;
    private Integer customerUserId;
    private Integer listingId;
    private Integer peopleCount;
    private LocalDate checkIn;
    private LocalDate checkOut;
    private String status;
}