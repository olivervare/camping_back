package ee.camping.back_camping.business.users;

import ee.camping.back_camping.domain.user.User;
import ee.camping.back_camping.domain.user.UserMapper;
import ee.camping.back_camping.domain.user.UserService;
import ee.camping.back_camping.domain.user.role.Role;
import ee.camping.back_camping.domain.user.role.RoleService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class UsersService {

    public static final int ROLE_ID_CUSTOMER = 2;
    @Resource
    private UserService userService;
    @Resource
    private RoleService roleService;
    @Resource
    private UserMapper userMapper;

    public void addUser(NewUsersDto newUsersDto) {
        userService.validateIfUsernameIsAvailable(newUsersDto.getUsername());   //valideerib kasutajakoha
        User user = userMapper.toUser(newUsersDto);                             //mäpib dto-s user-tabeli väljad (FK-d ei saa mäppida)
        Role role = roleService.findRoleBy(ROLE_ID_CUSTOMER);                   //getib role-tabelist roleId (FK)
        user.setRole(role);                                                     //paneb selle user-tabelisse

        userService.addUser(user);                              //lisab kasutaja user tabelisse.
    }
}
