package ee.camping.back_camping.business.users;

import ee.camping.back_camping.business.dto.LoginResponseDto;
import ee.camping.back_camping.domain.user.User;
import ee.camping.back_camping.domain.user.UserMapper;
import ee.camping.back_camping.domain.user.UserService;
import ee.camping.back_camping.domain.user.contact.Contact;
import ee.camping.back_camping.domain.user.contact.ContactMapper;
import ee.camping.back_camping.domain.user.contact.ContactService;
import ee.camping.back_camping.domain.user.role.Role;
import ee.camping.back_camping.domain.user.role.RoleService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsersService {

    public static final int ROLE_ID_CUSTOMER = 2;
    @Resource
    private UserService userService;
    @Resource
    private RoleService roleService;
    @Resource
    private ContactService contactService;
    @Resource
    private UserMapper userMapper;
    @Resource
    private ContactMapper contactMapper;

    public LoginResponseDto addUser(NewUserDto newUserDto) {
        userService.validateIfUsernameIsAvailable(newUserDto.getUsername());   //valideerib kasutajakoha
        User user = userMapper.toUser(newUserDto);                             //mäpib dto-s user-tabeli väljad (FK-d ei saa mäppida)
        Role role = roleService.findRoleBy(ROLE_ID_CUSTOMER);                   //getib role-tabelist roleId (FK)
        user.setRole(role);                                                     //paneb selle user-tabelisse

        userService.addUser(user);                              //lisab kasutaja user tabelisse.
        return userMapper.toLoginResponseDto(user);             //tagastab loginmäpperiga lisatud useri userId ja roleName'i
    }

    @Transactional
    public void addUserContact(ContactDto contactDto) {
        Contact contact = contactMapper.toContact(contactDto);
        User user = userService.findUserBy(contactDto.getUserId());
        contact.setUser(user);
        contactService.addUserContact(contact);
    }

    public void deleteUser(Integer userId) {
        userService.deleteUserBy(userId);
    }
}
