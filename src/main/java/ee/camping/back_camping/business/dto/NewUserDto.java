package ee.camping.back_camping.business.dto;

import ee.camping.back_camping.domain.user.User;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link User} entity
 */
@Data
public class NewUserDto implements Serializable {
    private String username;
    private String password;
}