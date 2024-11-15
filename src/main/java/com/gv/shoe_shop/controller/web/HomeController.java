package com.gv.shoe_shop.controller.web;

import com.gv.shoe_shop.constants.StringConstant;
import com.gv.shoe_shop.dto.response.UserResponse;
import com.gv.shoe_shop.service.UserService;
import jakarta.servlet.http.HttpSession;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class HomeController {
    UserService userService;

    @GetMapping("/home")
    public String home( ) {
        return "web/index";
    }
    @ModelAttribute
    public void commonUser(Principal p, HttpSession session) {
        if (p != null) {
            String username = p.getName();
            UserResponse user = userService.findByUsername(username);
            if (user != null)
                session.setAttribute(StringConstant.USER, user);
        }
    }
}
