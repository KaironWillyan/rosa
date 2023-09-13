package com.project.rosa.controller;


import com.project.rosa.models.Product;
import com.project.rosa.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RequestMapping("/products")
@Controller
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/")
    public RedirectView index(){
        return new RedirectView("/products");
    }

    @GetMapping("/status")
    public void status(){}

    @GetMapping("/teste")
    public String teste(@RequestParam(value = "name", required = false, defaultValue = "Marisa") String name, Model model){
        model.addAttribute("name",name);
        return "teste";
    }

    @GetMapping("/form")
    public String productForm(Product product){
        return "addProductForm";
    }
    @PostMapping("/add")
    public String createNewProduct(@Validated Product product, BindingResult result) {
        if(result.hasFieldErrors()){
            return "redirect:/form";
        }
        productRepository.save(product);

        return "redirect:/index";
    }
    @GetMapping("/form/{id}")
    public String updateProductForm(Model model, @PathVariable(name = "id") Integer id){
        Product product = productRepository.findById(id)
                .orElseThrow(()-> new
                        IllegalArgumentException("Invalid product Id: "+ id));
        model.addAttribute("product", product);
        return "updateProductForm";
    }

    @PutMapping("update/{id}")
    public String updateProduct(@Validated Product product, BindingResult result, @PathVariable(name = "id") Integer id){
        if(result.hasFieldErrors()){
            return "redirect:/form";
        }
        productRepository.save(product);

        return "redirect:/index";
    }

    @DeleteMapping("delete/{id}")
    public String deleteProduct(@PathVariable(name = "id") Integer id, Model model){
        Product product = productRepository.findById(id)
                .orElseThrow(()-> new
                IllegalArgumentException("Invalid product Id: "+ id));

        return "redirect:/index";
    }

}
