package rali.org.bravediy.services.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class UserServiceModel extends BaseServiceModel {

    private String username;
    private String password;
    private String email;

    private Set<RoleServiceModel> authorities;


}
