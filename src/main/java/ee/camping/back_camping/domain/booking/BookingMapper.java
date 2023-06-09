package ee.camping.back_camping.domain.booking;

import ee.camping.back_camping.business.Status;
import ee.camping.back_camping.business.dto.AddBookingResponse;
import ee.camping.back_camping.business.dto.BookingDto;
import ee.camping.back_camping.business.dto.NewBookingDto;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING, imports = {Status.class})
public interface BookingMapper {

    @Mapping(source = "id", target = "bookingId")
    @Mapping(source = "status", target = "bookingStatus")
    @Mapping(source = "checkIn", target = "checkInDate")
    @Mapping(source = "checkOut", target = "checkOutDate")
    @Mapping(source = "listing.id", target = "listingId")
    @Mapping(source = "listing.ownerUser.id", target = "ownerUserId")
    @Mapping(source = "listing.name", target = "listingName")
    @Mapping(source = "listing.price", target = "listingPrice")
    @Mapping(source = "customerUser.id", target = "customerUserId")
    @Mapping(source = "customerUser.username", target = "customerUserName")
    BookingDto toBookingDto(Booking booking);

    List<BookingDto> toBookingDtos(List<Booking> booking);

    @Mapping(expression = "java(Status.PENDING.getLetter())", target = "status")
    Booking toBooking(NewBookingDto newBookingDto);

    @Mapping(source = "id", target = "bookingId")
    AddBookingResponse toAddBookingResponse(Booking booking);

}