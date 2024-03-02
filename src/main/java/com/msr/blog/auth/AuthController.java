package com.msr.blog.auth;

import com.msr.blog.MasUser.MasUser;
import com.msr.blog.MasUser.MasUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    public String register(@ModelAttribute MasUser masUser, Model model)
    {
        masUserService.save(masUser);
        return "redirect:/";
    }

}
