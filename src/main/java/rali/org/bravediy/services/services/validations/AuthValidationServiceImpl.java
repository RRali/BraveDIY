package rali.org.bravediy.services.services.validations;

import org.springframework.stereotype.Service;
import rali.org.bravediy.data.repositories.UsersRepository;
import rali.org.bravediy.services.models.auth.RegisterUserServiceModel;

@Service
public class AuthValidationServiceImpl implements AuthValidationService {
    private final UsersRepository usersRepository;

    public AuthValidationServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public boolean isValid(RegisterUserServiceModel user) {
        return this.isEmailValid(user.getEmail()) &&
                this.arePasswordsValid(user.getPassword(), user.getConfirmPassword()) &&
                this.isUsernameFree(user.getUsername());
    }

    private boolean arePasswordsValid(String password, String confirmPassword) {
        return password.equals(confirmPassword);
    }

    private boolean isUsernameFree(String username) {
        return !usersRepository.existsByUsername(username);
    }

    private boolean isEmailValid(String email) {
        return true;
    }
}
