package org.solution.projet.security.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecurityControllers {
    @GetMapping("/")
    public String home()
    {
        return "redirect:/avocatsList";
    }

    @GetMapping("/accessDenied")
    public String accessDenied()
    {
        return "/AccessDenied";
    }
}
