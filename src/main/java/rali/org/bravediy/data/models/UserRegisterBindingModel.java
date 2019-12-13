package rali.org.bravediy.data.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRegisterBindingModel {

    private String username;
    private String password;
    private String confirmPassword;
    private String email;

}
