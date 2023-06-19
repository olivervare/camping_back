package ee.camping.back_camping.domain.booking;

import ee.camping.back_camping.business.Status;
import ee.camping.back_camping.business.dto.BookingResponse;
import ee.camping.back_camping.business.dto.NewBookingDto;
import org.mapstruct.*;

import java.awt.print.Book;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING, imports = {Status.class})
public interface BookingMapper {

    @Mapping(expression = "java(Status.PENDING.getLetter())", target = "status")
    Booking toBooking(NewBookingDto newBookingDto);

    @Mapping(source = "", target = "bookingId")
    BookingResponse toBookingResponse(BookingResponse bookingResponse);
}