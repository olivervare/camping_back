package ee.camping.back_camping.domain.listing;

import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ListingMapper {
//    @Mapping(source = "ownerUserId", target = "ownerUser.id")
//    Listing toEntity(ListingDto listingDto);

    List<ListingPreviewDto> toListingPreviewsDto(List<Listing> myListings);

}