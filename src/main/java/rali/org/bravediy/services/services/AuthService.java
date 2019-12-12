package rali.org.bravediy.services.services;


import rali.org.bravediy.services.models.auth.LoginUserServiceModel;
import rali.org.bravediy.services.models.auth.RegisterUserServiceModel;

public interface AuthService {
    void register(RegisterUserServiceModel model);

    LoginUserServiceModel login(RegisterUserServiceModel serviceModel) throws Exception;
}
