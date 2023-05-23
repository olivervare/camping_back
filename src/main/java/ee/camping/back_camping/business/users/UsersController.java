package ee.camping.back_camping.business.users;

import ee.camping.back_camping.business.dto.LoginResponseDto;
import ee.camping.back_camping.infrastructure.error.ApiError;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

@RestController
public class UsersController {

    @Resource
    private UsersService usersService;

    @PostMapping("/signup")
    @Operation(summary = "Loob uue username ja passwordi", description = "Kui username on juba olemas, tagastab vea 222")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "403", description = "Sellise nimega pangaautomaadi asukoht on juba süsteemis olemas", content = @Content(schema = @Schema(implementation = ApiError.class)))})
    public LoginResponseDto addUser(@RequestBody NewUserDto newUserDto) {
        return usersService.addUser(newUserDto);
    }

    @PostMapping("/signup-info")
    @Operation(summary = "Loob username'i ja passwordi juurde kontaktandmed")
    public void addContact(@RequestBody ContactDto contactDto) {
        usersService.addContact(contactDto);
    }

    @DeleteMapping("/signup-info")
    @Operation(summary = "Poolelioleva kasutaja kustutamine", description = "Kasutaja kustutamine userId kaudu")
    public void deleteUser(@RequestParam Integer userId) {
        usersService.deleteUser(userId);
    }

    @GetMapping("/my-profile")
    @Operation(summary = "Tagastab kasutaja andmed kontakt-tabelist")
    public ContactDto getContact(@RequestParam Integer userId) {
        return usersService.getContact(userId);
    }

    @PutMapping("/my-profile")
    @Operation(summary = "Muudab kasutaja andmeid", description = "Kasutaja saab muuta oma nime, emaili, telnumbrit ja pilti")
    public void editContact(@RequestParam Integer contactId, @RequestBody ContactDto contactDto) {
        usersService.editContact(contactId, contactDto);
    }
}
