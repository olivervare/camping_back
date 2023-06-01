package ee.camping.back_camping.domain.listing.location;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountyService {
    @Resource
    private CountyRepository countyRepository;


    public List<County> getCounties() {
        return countyRepository.findAll();
    }

    public County getCountyBy(Integer locationCountyId) {
        return countyRepository.findById(locationCountyId).get();
    }
}
