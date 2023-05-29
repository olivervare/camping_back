package ee.camping.back_camping.domain.listing.location;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LocationService {

    @Resource
    private LocationRepository locationRepository;

    public Optional<Location> findLocationBy(Integer locationId) {
        return locationRepository.findLocationBy(locationId);
    }
    public Location findCountyBy(Integer countyId) {
        return locationRepository.findCountyBy(countyId);
    }

    public void saveLocation(Location location) {
        locationRepository.save(location);
    }

//    public Location getLocationBy(Integer locationId) {
//        locationRepository.find
//    }

//    public void getLocationBy(Integer listingId) {
//        locationRepository.getLocationBy(listingId);
//    }
}
