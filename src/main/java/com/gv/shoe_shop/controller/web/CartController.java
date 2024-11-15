package com.gv.shoe_shop.controller.web;

import com.gv.shoe_shop.constants.StringConstant;
import com.gv.shoe_shop.dto.request.CartRequest;
import com.gv.shoe_shop.dto.response.UserResponse;
import com.gv.shoe_shop.service.CartService;
import jakarta.servlet.http.HttpSession;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/web")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CartController {
    CartService cartService;

    @GetMapping("/cart")
    public String showCart(HttpSession session, Model model) {
        var user = (UserResponse) session.getAttribute(StringConstant.USER);
        var cart = cartService.getCartByUser(user);
        model.addAttribute("cart", cart);
        return "web/cart";
    }

    @PostMapping("/cart")
    public String addCart(CartRequest cartRequest, HttpSession session, RedirectAttributes attributes){
        var user = (UserResponse) session.getAttribute(StringConstant.USER);
        var cart = cartService.saveCart(cartRequest, user);
        attributes.addFlashAttribute("cart", cart);
        return "redirect:/web/cart";
    }

    @PostMapping("/update-cart")
    public String updateCart(String id, String productId, int quantity, RedirectAttributes attributes){
        var cart = cartService.updateCart(id, productId, quantity);
        attributes.addFlashAttribute("cart", cart);
        return "redirect:/web/cart";
    }
}
