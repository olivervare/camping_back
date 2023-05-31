package ee.camping.back_camping.domain.review;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Integer> {

    @Query("select new ee.camping.back_camping.domain.review.ScoreInfo(count(r), avg(r.score)) from Review r where r.listing.id = ?1")
    ScoreInfo findScoreInfo(Integer id);

}