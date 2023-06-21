package ee.camping.back_camping.business.booking;

import ee.camping.back_camping.business.dto.BookingDto;
import ee.camping.back_camping.business.dto.BookingResponse;
import ee.camping.back_camping.business.dto.NewBookingDto;
import ee.camping.back_camping.domain.booking.Booking;
import ee.camping.back_camping.domain.booking.BookingMapper;
import ee.camping.back_camping.domain.booking.BookingService;
import ee.camping.back_camping.domain.listing.Listing;
import ee.camping.back_camping.domain.listing.ListingService;
import ee.camping.back_camping.domain.user.User;
import ee.camping.back_camping.domain.user.UserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookingsService {

    @Resource
    private BookingService bookingService;
    @Resource
    private ListingService listingService;
    @Resource
    private UserService userService;
    @Resource
    private BookingMapper bookingMapper;

    public List<BookingDto> findBookingsBy(Integer customerUserId) {
        List<Booking> bookings = bookingService.findBookingsBy(customerUserId);
        return bookingMapper.toBookingDtos(bookings);
    }
    @Transactional
    public BookingResponse addNewBooking(NewBookingDto newBookingDto) {
        // todo: valideeri kuupäevade võimalikkus.
        Booking booking = bookingMapper.toBooking(newBookingDto);
        Listing listingId = listingService.getListingBy(newBookingDto.getListingId());
        User customerUserId = userService.findUserBy(newBookingDto.getCustomerUserId());
        booking.setListing(listingId);
        booking.setCustomerUser(customerUserId);
        bookingService.addBooking(booking);

        return bookingMapper.toBookingResponse(booking);
    }
    public void deleteBooking(Integer bookingId) {
        bookingService.deleteBookingBy(bookingId);
    }

    public void confirmBooking(String bookingStatus, Integer bookingId) {
        bookingService.updateBookingStatus(bookingStatus, bookingId);

    }
}
