package ee.camping.back_camping.domain.listing.location;

import ee.camping.back_camping.business.dto.AddFullListingDto;
import ee.camping.back_camping.business.dto.LocationDto;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface LocationMapper {

    @Mapping(source = "id", target = "locationId")
    @Mapping(source = "address", target = "locationAddress")
    @Mapping(source = "longitude", target = "locationLongitude")
    @Mapping(source = "latitude", target = "locationLatitude")
    LocationDto toLocationDto(Location location);

    @Mapping(source = "locationAddress", target = "address")
    @Mapping(source = "locationLatitude", target = "latitude")
    @Mapping(source = "locationLongitude", target = "longitude")
    Location toLocation(AddFullListingDto addFullListingDto);
}