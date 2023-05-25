package ee.camping.back_camping.domain.listing.location;

import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface LocationMapper {

    @Mapping(source = "id", target = "locationId")
    @Mapping(source = "address", target = "locationAddress")
    @Mapping(source = "longitude", target = "locationLongitude")
    @Mapping(source = "latitude", target = "locationLatitude")
    LocationDto toLocationDto(Location location);

}