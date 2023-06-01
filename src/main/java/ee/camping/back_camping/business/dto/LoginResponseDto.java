package ee.camping.back_camping.business.dto;

import ee.camping.back_camping.domain.user.User;
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