package ee.camping.back_camping.domain.listing.location;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface LocationRepository extends JpaRepository<Location, Integer> {
    @Query("select l from Location l where l.id = ?1")
    Optional<Location> findLocationBy(Integer id);

}