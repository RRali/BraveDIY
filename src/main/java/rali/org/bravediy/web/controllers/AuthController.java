package rali.org.bravediy.web.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import rali.org.bravediy.web.models.RegisterUserModel;

import javax.validation.Valid;


@Controller
@RequestMapping
public class AuthController {

    @GetMapping("/login")
    public String getLoginForm() {
        return "login.html";
    }

    @GetMapping("/register")
    public String getRegisterForm() {
//        model.addAttribute("model", new RegisterUserModel());
        return "register.html";
    }
    @PostMapping("/register")
    public String register( @ModelAttribute RegisterUserModel model) {
//        if (bindingResult.hasErrors()) {
//            return "auth/register.html";
//        }
//        RegisterUserServiceModel serviceModel = mapper.map(model, RegisterUserServiceModel.class);
//        authService.register(serviceModel);
        return "redirect:/";
    }

}

