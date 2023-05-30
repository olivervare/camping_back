package ee.camping.back_camping.business.county;

import ee.camping.back_camping.business.dto.CountyDto;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CountiesController {
    @Resource
    private CountiesService countiesService;

    @GetMapping("/add-listing-counties")
    @Operation(summary = "Tagastab kõikide maakondade id-d ja nimed")
    public List<CountyDto> getCounties() {
        return countiesService.getCounties();
    }
}
