package rali.org.bravediy.services.services;


import org.springframework.security.core.userdetails.UserDetailsService;
import rali.org.bravediy.services.models.UserServiceModel;

import javax.management.relation.RoleNotFoundException;
import java.util.List;

public interface UserService extends UserDetailsService {

    UserServiceModel registerUser(UserServiceModel userServiceModel) throws RoleNotFoundException;

    UserServiceModel findUserByUserName(String username);

    UserServiceModel editUserProfile(UserServiceModel userServiceModel, String oldPassword);

    List<UserServiceModel> findAllUsers();

    void setUserRole(String id, String role) throws RoleNotFoundException;
}
