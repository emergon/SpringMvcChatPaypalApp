package com.emergon.service;

import com.emergon.model.OrderDetail;
import com.emergon.model.Product;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    public List<Product> getProducts() {
        List<Product> products = new ArrayList<Product>();
        products.add(new Product("Shirt", 10));
        products.add(new Product("Plate", 20));
        products.add(new Product("Paper", 30));
        products.add(new Product("Shoe", 40));
        return products;
    }

    public Product getProductByName(String name) {
        for (Product p : getProducts()) {
            if (p.getName().equals(name)) {
                return p;
            }
        }
        return null;
    }
    
    public OrderDetail prepareOrderDetail(OrderDetail orderDetail){
        float subtotal = 0.0f;
        for(Product p: orderDetail.getProducts()){
            subtotal += p.getPrice();
        }
        orderDetail.setProductName(orderDetail.getProducts().toString());
        orderDetail.setSubtotal(subtotal);
        orderDetail.setShipping(2f);
        orderDetail.setTax(5f);
        orderDetail.setTotal(subtotal+2+5);
        return orderDetail;
    }
}
