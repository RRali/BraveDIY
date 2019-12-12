package rali.org.bravediy.services.services.validations;

import rali.org.bravediy.services.models.auth.RegisterUserServiceModel;

public interface AuthValidationService {
    boolean isValid(RegisterUserServiceModel user);
}
