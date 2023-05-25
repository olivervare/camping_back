package ee.camping.back_camping.domain.listing;

import ee.camping.back_camping.business.listings.FullListingDto;
import ee.camping.back_camping.business.listings.ListingPreviewDto;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ListingMapper {

    @Mapping(source = "id", target = "listingId")
    @Mapping(source = "name", target = "listingName")
    ListingPreviewDto toListingPreviewDto(Listing listing);

    List<ListingPreviewDto> toListingPreviewDtos(List<Listing> myListings);

//    @Mapping(source = "id", target = "listingId")
    @Mapping(source = "name", target = "listingName")
    @Mapping(source = "description", target = "listingDescription")
    @Mapping(source = "additionalInfo", target = "listingAdditionalInfo")
    @Mapping(source = "location.county.id", target = "countyId")
    @Mapping(source = "location.county.name", target = "countyName")
    @Mapping(source = "location.id", target = "locationId")
    @Mapping(source = "location.longitude", target = "locationLongitude")
    @Mapping(source = "location.latitude", target = "locationLatitude")
    @Mapping(source = "location.address", target = "locationAddress")
    FullListingDto toAllListingsDto(Listing listing);

    List<FullListingDto> toAllListingsDtos(List<Listing> allListings);
}