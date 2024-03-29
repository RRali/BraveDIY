package rali.org.bravediy.services.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RoleServiceModel extends BaseServiceModel {

    private String authority;

    @Override
    public String toString() {
        return this.getAuthority();
    }
}
