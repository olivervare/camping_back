package ee.camping.back_camping.domain.listing.location;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LocationService {

    @Resource
    private LocationRepository locationRepository;

    public void saveLocation(Location location) {
        locationRepository.save(location);
    }

    public void deleteById(Integer locationId) {
        locationRepository.deleteById(locationId);
    }
}
