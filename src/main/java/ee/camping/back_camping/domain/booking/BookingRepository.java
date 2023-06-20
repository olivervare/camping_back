package ee.camping.back_camping.domain.booking;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookingRepository extends org.springframework.data.jpa.repository.JpaRepository<Booking, Integer> {
    @Query("select b from Booking b where b.customerUser.id = :id order by b.checkIn")
    List<Booking> findBookingsBy(@Param("id") Integer id);

}