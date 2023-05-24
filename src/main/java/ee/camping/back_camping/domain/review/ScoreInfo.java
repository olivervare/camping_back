package ee.camping.back_camping.domain.review;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ScoreInfo implements Serializable {

    private Long numberOfScores;
    private Double averageScore;
}
