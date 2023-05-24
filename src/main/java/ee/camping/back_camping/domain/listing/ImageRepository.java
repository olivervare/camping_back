package ee.camping.back_camping.domain.listing;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ImageRepository extends JpaRepository<Image, Integer> {
    @Query("select i from Image i where i.listing.id = ?1")
    List<Image> getListingImagesBy(Integer id);


}