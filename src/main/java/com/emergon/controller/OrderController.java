package com.emergon.controller;

import com.emergon.model.OrderDetail;
import com.emergon.model.Product;
import com.emergon.model.ProductEditor;
import com.emergon.service.OrderService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class OrderController {

    @Autowired
    OrderService service;

    @GetMapping("/products")
    public String showProducts(OrderDetail orderDetail, Model model) {

        model.addAttribute("productList", productList());
        return "selectProducts";
    }

    @ModelAttribute("productsList")
    public List<Product> productList() {
        List<Product> products = service.getProducts();
        return products;
    }

    @InitBinder//Create customEditor for converting String to Product
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Product.class,
                new ProductEditor(service));
    }

    @PostMapping("/cart")
    public String checkout(@ModelAttribute("orderDetail") @Valid OrderDetail orderDetail, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("productList", productList());
            return "selectProducts";
        }
        for (Product p : orderDetail.getProducts()) {
            System.out.println(p);
        }
        orderDetail = service.prepareOrderDetail(orderDetail);
        model.addAttribute("orderDetail", orderDetail);
        return "checkout";
    }

}
