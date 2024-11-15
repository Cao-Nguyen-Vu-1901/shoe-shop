package com.gv.shoe_shop.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.gv.shoe_shop.service.ProductService;

@Controller
public class HomeController {
    @Autowired
    private ProductService productService;

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("products", productService.getTopProducts());
        return "web/index";
    }

    @GetMapping("/home/details/{id}")
    public String detailsProduct(@PathVariable("id") String id, Model model){
        model.addAttribute("product", productService.getProductById(id));
        return "web/detail";
    }

   
}
