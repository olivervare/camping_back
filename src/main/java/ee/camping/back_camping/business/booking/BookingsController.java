package ee.camping.back_camping.business.booking;

import ee.camping.back_camping.business.dto.BookingResponse;
import ee.camping.back_camping.business.dto.NewBookingDto;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookingsController {

    @Resource
    private BookingsService bookingsService;

    @PostMapping("/bookListing")
    @Operation(summary = "Loob booking-tabelisse uue broneeringu",
            description = "Valideerib userId ja listingId ning selle, et küsialused kuupäevad on vabad, tagastab broneeringustaatuse")
    public BookingResponse addBooking(@RequestBody NewBookingDto newBookingDto) {
        return bookingsService.addNewBooking(newBookingDto);
    }
}
