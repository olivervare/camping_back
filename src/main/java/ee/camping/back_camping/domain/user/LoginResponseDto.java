package ee.camping.back_camping.domain.user;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link User} entity
 */
@Data
public class LoginResponseDto implements Serializable {
    private final Integer userId;
    private final String roleName;
}