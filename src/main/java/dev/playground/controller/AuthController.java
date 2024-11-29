package dev.playground.controller;

import dev.playground.persistence.dto.RegistrationDto;
import dev.playground.persistence.entity.User;
import dev.playground.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    /**
     * HOME PAGE
     *
     * @return - home/index page
     */
    @GetMapping("/")
    public String homePage(){
        return "home";
    }

    /**
     * LOGIN PAGE
     *
     * @return - custom login page (form)
     */
    @GetMapping("/login")
    public String loginPage(){
        return "login";
    }

    /**
     * REGISTER USER PAGE
     *
     * @param model - model representation of user object (empty)
     * @return      - page with user register form
     */
    @GetMapping("/register")
    public String getRegisterForm(Model model) {
        RegistrationDto user = new RegistrationDto();
        model.addAttribute("user", user);
        return "register";
    }

    /**
     * SUBMIT USER REGISTRATION (SAVE USER)
     *
     * @param user   - data transfer object of user (registration data)
     * @param result -
     * @param model  - model of user object
     * @return       - page with groups / fail registration page in case of errors
     */
    @PostMapping("/register/save")
    public String register(@Valid @ModelAttribute("user") RegistrationDto user,
                           BindingResult result, Model model) {

        User existingUserEmail = userService.findByEmail(user.getEmail());

        if(existingUserEmail != null && existingUserEmail.getEmail() != null && !existingUserEmail.getEmail().isEmpty()) {
            return "redirect:/register?fail";
        }

        User existingUserUsername = userService.findByUsername(user.getUsername());

        if(existingUserUsername != null && existingUserUsername.getUsername() != null && !existingUserUsername.getUsername().isEmpty()) {
            return "redirect:/register?fail";
        }

        if(result.hasErrors()) {
            model.addAttribute("user", user);
            return "register";
        }

        userService.saveUser(user);
        return "redirect:/groups?success";
    }

}
