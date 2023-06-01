package ee.camping.back_camping.domain.listing.feature;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ListingFeatureRepository extends JpaRepository<ListingFeature, Integer> {
    @Query("select l from ListingFeature l where l.listing.id = ?1")
    List<ListingFeature> findAllBy(Integer id);

    @Query("select l from ListingFeature l where l.feature.id = :id and l.isSelected = :isSelected")
    List<ListingFeature> findListingIdByFeatureIdAndIsSelected(@Param("id") Integer id, @Param("isSelected") Boolean isSelected);

    @Query("select l from ListingFeature l where l.feature.id = ?1 and l.isSelected = ?2")
    List<ListingFeature> getListingId(Integer featureId, Boolean isSelected);

    @Query("select l from ListingFeature l where l.feature.id = ?1 and l.isSelected = ?2")
    ListingFeature getFeatureBy(Integer featureId, Boolean featureIsSelected);

}