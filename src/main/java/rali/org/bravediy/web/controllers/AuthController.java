package rali.org.bravediy.web.controllers;


import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import rali.org.bravediy.data.models.Profile;
import rali.org.bravediy.data.repositories.ProfilesRepository;
import rali.org.bravediy.services.models.auth.LoginUserServiceModel;
import rali.org.bravediy.services.models.auth.RegisterUserServiceModel;
import rali.org.bravediy.services.services.AuthService;
import rali.org.bravediy.web.models.RegisterUserModel;

import javax.servlet.http.HttpSession;
import java.util.Optional;


@Controller
@RequestMapping
public class AuthController {

    private final AuthService authService;
    private final ModelMapper mapper;
   private final ProfilesRepository profilesRepository;

    public AuthController(
            AuthService authService,
            ModelMapper mapper, ProfilesRepository profilesRepository) {
        this.authService = authService;
        this.mapper = mapper;
        this.profilesRepository = profilesRepository;
    }

    @GetMapping("/login")
    public String getLoginForm() {
        return "login.html";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute RegisterUserModel model, HttpSession session) {
        RegisterUserServiceModel serviceModel = mapper.map(model, RegisterUserServiceModel.class);
        try {
            LoginUserServiceModel loginUserServiceModel = authService.login(serviceModel);
            Optional<Profile> profile = profilesRepository
                    .getByUserUsername(loginUserServiceModel.getUsername());
            profile.ifPresent(value -> loginUserServiceModel.setName(value.getName()));
            session.setAttribute("user", loginUserServiceModel);
            return "redirect:/";
        } catch (Exception ex) {
            return "redirect:/login";
        }
//        try {
//            LoginUserServiceModel loginUserServiceModel = authService.login(serviceModel);
//            session.setAttribute("user", loginUserServiceModel);
//            return "redirect:/";
//        } catch (Exception ex) {
//            return "redirect:/login";
//        }
    }

    @GetMapping("/register")
    public String getRegisterForm() {

        return "register.html";
    }
    @PostMapping("/register")
    public String register(@ModelAttribute RegisterUserModel model) {

        RegisterUserServiceModel serviceModel = mapper.map(model, RegisterUserServiceModel.class);
        authService.register(serviceModel);
        return "redirect:/login";
    }

}

