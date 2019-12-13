package rali.org.bravediy.services.services;



import rali.org.bravediy.services.models.RoleServiceModel;

import javax.management.relation.RoleNotFoundException;
import java.util.Set;

public interface RoleService {

    void seedRolesInDb();

//    void assignUserRoles(UserServiceModel userServiceModel, long numberOfUsers);

    Set<RoleServiceModel> findAllRoles();

    RoleServiceModel findByAuthority(String authority) throws RoleNotFoundException;
}
