package rali.org.bravediy.services.models.auth;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class LoginUserServiceModel {
    private String username;
    private String name;

    public LoginUserServiceModel(String username, String name) {
        this.username = username;
        this.name = name;
    }
}
