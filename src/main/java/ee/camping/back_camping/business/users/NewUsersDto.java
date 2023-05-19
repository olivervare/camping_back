package ee.camping.back_camping.business.users;

import ee.camping.back_camping.domain.user.User;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link User} entity
 */
@Data
public class NewUsersDto implements Serializable {
    @Size(max = 255)
    @NotNull
    private String username;
    @Size(max = 255)
    @NotNull
    private String password;
}