package ee.camping.back_camping.business.county;

import ee.camping.back_camping.business.dto.CountyDto;
import ee.camping.back_camping.domain.listing.location.County;
import ee.camping.back_camping.domain.listing.location.CountyMapper;
import ee.camping.back_camping.domain.listing.location.CountyService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountiesService {

    @Resource
    private CountyService countyService;
    @Resource
    private CountyMapper countyMapper;

    public List<CountyDto> getCounties() {
        List<County> counties = countyService.getCounties();
        return countyMapper.toCountyDtos(counties);
    }
}
