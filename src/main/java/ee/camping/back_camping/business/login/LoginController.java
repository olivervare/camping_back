package ee.camping.back_camping.business.login;

import ee.camping.back_camping.domain.user.LoginResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @Resource
    private LoginService loginService;

    @GetMapping("/login")
    @Operation(summary = "Tagastab userId ja roleName'i.",
            description = """
                    Süsteemist otsitakse username ja passwordi abil kasutajat, kelle konto on aktiivne. 
                    Kui vastust ei leita, visatakse viga errorCode'ga 111.""")
    public LoginResponseDto login(@RequestParam String username, @RequestParam String password) {
        LoginResponseDto loginResponseDto = loginService.login(username, password);
        return loginResponseDto;
    }
}
