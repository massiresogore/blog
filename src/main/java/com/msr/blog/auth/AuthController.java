package com.msr.blog.auth;

import com.msr.blog.MasUser.MasUser;
import com.msr.blog.MasUser.MasUserService;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("auth")
public class AuthController {
    private final MasUserService masUserService;

    public AuthController(MasUserService masUserService) {
        this.masUserService = masUserService;
    }

    @GetMapping("/register")
    public String index(Model model)
    {
        model.addAttribute("user",new MasUser());
        return "auth/register";
    }

    @PostMapping
    public String register(@Valid @ModelAttribute MasUser masUser,
                           BindingResult result,
                           RedirectAttributes atts,
                           Model model)
    {
        if(result.hasFieldErrors()){
        model.addAttribute("user",masUser);
//            atts.addAttribute("name", masUser.getUsername());
//            atts.addAttribute("email", masUser.getName());
            return "auth/register";
        }

        if(masUserService.findManUserByUsername(masUser.getUsername()) != null){
            model.addAttribute( "unique", "Ce login existe déjà! " );
            model.addAttribute("user",new MasUser());
            return "auth/register";
        }

        masUserService.save(masUser);
        return "redirect:/";


    }

}
