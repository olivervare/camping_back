package ee.camping.back_camping.domain.listing.feature;

import ee.camping.back_camping.business.FeaturesController;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeatureService {
    private FeatureRepository featureRepository;

    public FeatureService(FeatureRepository featureRepository) {
        this.featureRepository = featureRepository;
    }

    public Feature getFeatureBy(Integer featureId) {
        return featureRepository.findById(featureId).get();
    }

    public List<Feature> getFeatures() {
        return featureRepository.findAll();
    }
}
