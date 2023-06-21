package ee.camping.back_camping.domain.booking;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {

    @Resource
    private BookingRepository bookingRepository;

    public void addBooking(Booking booking) {
        bookingRepository.save(booking);
    }

    public void deleteBookingBy(Integer bookingId) {
        bookingRepository.deleteById(bookingId);
    }

    public List<Booking> findBookingsBy(Integer customerUserId) {
        return bookingRepository.findBookingsBy(customerUserId);
    }

    public void updateBookingStatus(String status, Integer bookingId) {
        bookingRepository.updateStatus(status, bookingId);
    }
}
