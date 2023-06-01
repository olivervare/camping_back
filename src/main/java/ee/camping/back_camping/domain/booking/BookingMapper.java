package ee.camping.back_camping.domain.booking;

import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface BookingMapper {
    @Mapping(source = "listingId", target = "listing.id")
    @Mapping(source = "customerUserId", target = "customerUser.id")
    Booking toEntity(BookingDto bookingDto);

    @InheritInverseConfiguration(name = "toEntity")
    BookingDto toDto(Booking booking);

}