package ee.camping.back_camping.domain.listing.feature;

import org.springframework.stereotype.Service;

@Service
public class FeatureService {
    private FeatureRepository featureRepository;

    public FeatureService(FeatureRepository featureRepository) {
        this.featureRepository = featureRepository;
    }

    public Feature getFeatureBy(Integer featureId) {
        return featureRepository.findById(featureId).get();
    }
}
