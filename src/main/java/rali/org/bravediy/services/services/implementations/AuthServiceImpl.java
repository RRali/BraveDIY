package rali.org.bravediy.services.services.implementations;


import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import rali.org.bravediy.data.models.User;
import rali.org.bravediy.data.repositories.UsersRepository;
import rali.org.bravediy.services.models.auth.LoginUserServiceModel;
import rali.org.bravediy.services.models.auth.RegisterUserServiceModel;
import rali.org.bravediy.services.services.AuthService;
import rali.org.bravediy.services.services.HashingService;
import rali.org.bravediy.services.services.validations.AuthValidationService;

@Service
public class AuthServiceImpl implements AuthService {
    private final AuthValidationService authValidationService;
    private final UsersRepository usersRepository;
    private final ModelMapper mapper;
    private final HashingService hashingService;

    public AuthServiceImpl(
            AuthValidationService authValidationService,
            UsersRepository usersRepository,
            ModelMapper mapper,
            HashingService hashingService) {
        this.authValidationService = authValidationService;
        this.usersRepository = usersRepository;
        this.mapper = mapper;
        this.hashingService = hashingService;
    }

    @Override
    public void register(RegisterUserServiceModel model) {
        if (!authValidationService.isValid(model)) {
            // do something
            return;
        }

        User user = mapper.map(model, User.class);
        user.setPassword(hashingService.hash(user.getPassword()));
        usersRepository.save(user);
    }

    @Override
    public LoginUserServiceModel login(RegisterUserServiceModel serviceModel) throws Exception {
        String passwordHash = hashingService.hash(serviceModel.getPassword());
        return usersRepository
                .findByUsernameAndPassword(serviceModel.getUsername(), passwordHash)
                .map(user -> {
                    String name = user.getProfile() == null
                            ? null
                            : user.getProfile().getName();

                    return new LoginUserServiceModel(serviceModel.getUsername(), name);
                })
                .orElseThrow(() -> new Exception("Invalid user"));
    }
}
