package ee.camping.back_camping.domain.user;

import ee.camping.back_camping.business.Status;
import ee.camping.back_camping.validation.ValidationService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Resource
    private UserRepository userRepository;

    public User findActiveUserBy(String username, String password) {
        Optional<User> userOptional = userRepository.findUserBy(username, password, Status.ACTIVE.getLetter());
        ValidationService.validateUserCredentials(userOptional);
        return userOptional.get();
    }

    public void validateIfUsernameIsAvailable(String username) {
        boolean userExists = userRepository.doesUserExistBy(username);
        ValidationService.validateUsernameAvailability(userExists);
    }

    public void addUser(User user) {
        userRepository.save(user);
    }

    public User findUserBy(Integer userId) {
        return userRepository.findById(userId).get();
    }

    public void deleteUserBy(Integer userId) {
        userRepository.deleteById(userId);
    }
}
