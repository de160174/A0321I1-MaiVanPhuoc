package com.example.demo.controller;

import com.example.demo.model.Cart;
import com.example.demo.model.Product;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.util.HashMap;
import java.util.Map;

@Controller
public class CartController {
    @Autowired
    ProductService productService;
    @GetMapping("buy/{id}")
    public String addCart(@PathVariable String id, @SessionAttribute("carts")HashMap<String, Cart> hashMap, Model model){
        Product product=productService.findById(id);
        if(product!=null){
            // san pham chua có trong giỏ hàng
            if(!hashMap.containsKey(id)){
                Cart cart=new Cart();
                cart.setProduct(product);
                cart.setQuantity(1);
                hashMap.put(id,cart);
            }else {
                //san pham da co trong gio hang
                Cart cart=hashMap.get(id);
                cart.setQuantity(cart.getQuantity()+1);
                hashMap.put(id,cart);
            }
        }
        model.addAttribute("carts",hashMap);
        model.addAttribute("number",hashMap.size());
        model.addAttribute("money",total(hashMap));
        return "product/cart";
    }
    public double total(HashMap<String,Cart> cartHashMap){
        int count=0;
        for(Map.Entry<String,Cart> list:cartHashMap.entrySet()){
            count += list.getValue().getProduct().getPriceNew()*list.getValue().getQuantity();
        }
        return count;
    }
}
