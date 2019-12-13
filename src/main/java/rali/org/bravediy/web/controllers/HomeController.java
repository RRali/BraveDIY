package rali.org.bravediy.web.controllers;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import rali.org.bravediy.web.controllers.base.BaseController;


import java.util.stream.Collectors;

@Controller
@AllArgsConstructor
public class HomeController extends BaseController {

//    private final CategoryService categoryService;
//    private final ModelMapper modelMapper;


    @GetMapping("/")
    @PreAuthorize("isAnonymous()")
    public ModelAndView index() {
        return super.view("index");
    }

    @GetMapping("/home")
    @PreAuthorize("isAuthenticated()")
    public ModelAndView home(ModelAndView modelAndView) {
//        List<CategoryViewModel> categories = this.categoryService.findAllCategories()
//                .stream()
//                .map(category -> this.modelMapper.map(category, CategoryViewModel.class))
//                .collect(Collectors.toList());
//
//        modelAndView.addObject("categories", categories);

        return super.view("home", modelAndView);
    }
}
