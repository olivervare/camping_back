package ee.camping.back_camping.domain.listing.location;

import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface CountyMapper {

    @Mapping(source = "id", target = "countyId")
    @Mapping(source = "name", target = "countyName")
    CountyDto toCountyDto(County county);

}