package ee.camping.back_camping.domain.listing.location;

import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface LocationMapper {

    @Mapping(source = "address", target = "address")
    LocationDto toLocationDto(Location location);

}