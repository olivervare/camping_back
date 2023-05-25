package ee.camping.back_camping.domain.listing;

import ee.camping.back_camping.business.listings.AllListingsDto;
import ee.camping.back_camping.business.listings.ListingPreviewDto;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ListingMapper {

    @Mapping(source = "id", target = "listingId")
    @Mapping(source = "name", target = "listingName")
    ListingPreviewDto toListingPreviewDto(Listing listing);

    List<ListingPreviewDto> toListingPreviewDtos(List<Listing> myListings);

    @Mapping(source = "id", target = "listingId")
    @Mapping(source = "name", target = "listingName")
    @Mapping(source = "description", target = "listingDescription")
    @Mapping(source = "additionalInfo", target = "listingAdditionalInfo")
    @Mapping(source = "price", target = "price")
    @Mapping(source = "location", target = "locationDto")
    AllListingsDto toAllListingsDto(Listing listings);
    List<AllListingsDto> toAllListingsDtos(List<Listing> allListings);
}