package ee.camping.back_camping.domain.booking;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class BookingService {

    @Resource
    private BookingRepository bookingRepository;

    public void addBooking(Booking booking) {
        bookingRepository.save(booking);
    }
}
