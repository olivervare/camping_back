package ee.camping.back_camping.business.booking;

import ee.camping.back_camping.business.dto.AddBookingResponse;
import ee.camping.back_camping.business.dto.BookingDto;
import ee.camping.back_camping.business.dto.NewBookingDto;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookingsController {

    @Resource
    private BookingsService bookingsService;

    @GetMapping("/book-listing")
    @Operation(summary = "Tagastab customerUserId järgi booking-tabelist kõik kasutaja broneeringud")
    public List<BookingDto> findBookings(@RequestParam Integer customerUserId) {
        return bookingsService.findBookingsBy(customerUserId);
    }

    @PostMapping("/book-listing")
    @Operation(summary = "Loob booking-tabelisse uue broneeringu",
            description = "Valideerib userId ja listingId ning selle, et küsialused kuupäevad on vabad," +
                    " tagastab bookindId ja broneeringustaatuse")
    public AddBookingResponse addBooking(@RequestBody NewBookingDto newBookingDto) {
        return bookingsService.addNewBooking(newBookingDto);
    }

    @DeleteMapping("/book-listing")
    @Operation(summary = "Kustutab bookingId järgi booking-tabelist broneeringu")
    public void deleteBooking(@RequestParam Integer bookingId) {
        bookingsService.deleteBooking(bookingId);
    }

    @PatchMapping("/booking-confirmation")
    @Operation(summary = "Muudab bookingId järgi booking-tabelis broneeringu staatuse",
            description = "C - confirmed, R - rejected")
    public void confirmBooking(@RequestParam String bookingStatus, Integer bookingId) {
        bookingsService.confirmBooking(bookingStatus, bookingId);
    }
}
