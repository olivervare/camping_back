package ee.camping.back_camping.domain.booking;

import ee.camping.back_camping.business.Status;
import ee.camping.back_camping.business.dto.BookingDto;
import ee.camping.back_camping.business.dto.BookingResponse;
import ee.camping.back_camping.business.dto.NewBookingDto;
import org.mapstruct.*;

import java.awt.print.Book;
import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING, imports = {Status.class})
public interface BookingMapper {

    @Mapping(source = "id", target = "bookingId")
    @Mapping(source = "status", target = "bookingStatus")
    @Mapping(source = "listing.id", target = "listingId")
    @Mapping(source = "customerUser.id", target = "customerUserId")
    BookingDto toBookingDto(Booking booking);

    List<BookingDto> toBookingDtos(List<Booking> booking);

    @Mapping(expression = "java(Status.PENDING.getLetter())", target = "status")
    Booking toBooking(NewBookingDto newBookingDto);

    @Mapping(source = "id", target = "bookingId")
    BookingResponse toBookingResponse(Booking booking);
}