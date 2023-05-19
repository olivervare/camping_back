package ee.camping.back_camping.business.users;

import ee.camping.back_camping.infrastructure.error.ApiError;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsersController {

    @Resource
    private UsersService usersService;

    @PostMapping("/signup")
    @Operation(summary = "Loob uue username ja passwordi", description = "Kui username on juba olemas, tagastab vea 222")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "403", description = "Sellise nimega pangaautomaadi asukoht on juba süsteemis olemas", content = @Content(schema = @Schema(implementation = ApiError.class)))})
    public void addUser(@RequestBody NewUsersDto newUsersDto) {
        usersService.addUser(newUsersDto);
    }
}
