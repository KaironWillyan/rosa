package com.project.rosa.controller;


import com.project.rosa.models.Product;
import com.project.rosa.models.ProductStatus;
import com.project.rosa.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class IndexController {
    @Autowired
    private ProductRepository productRepository;
    @GetMapping("/index")
    public String index(Model model) {
        List<Product> product = productRepository.findAll();

        model.addAttribute("products", product);
        return "index";
    }

    @GetMapping
    public String status(@RequestParam(defaultValue = "INDISPONIVEL") String status, Model model) {
         ProductStatus productStatus = ProductStatus.valueOf(status.toUpperCase());
        List<Product> product = productRepository.findByStatus(productStatus);

        model.addAttribute("products", product);
        return "index";
    }
}
