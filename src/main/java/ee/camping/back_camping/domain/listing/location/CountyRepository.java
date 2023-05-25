package ee.camping.back_camping.domain.listing.location;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CountyRepository extends JpaRepository<County, Integer> {
    @Query("select c from County c where c.name = ?1")
    County findCountyBy(String name);

}