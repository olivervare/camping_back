package ee.camping.back_camping.business;

import ee.camping.back_camping.business.dto.CountyDto;
import ee.camping.back_camping.business.dto.FeatureDto;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FeaturesController {

    @Resource
    private FeaturesService featuresService;

    @GetMapping("/add-listing-features")
    @Operation(summary = "Tagastab kõikide feature'ide id-d ja nimed")
    public List<FeatureDto> getFeatures() {
        return featuresService.getFeatures();
    }
}
