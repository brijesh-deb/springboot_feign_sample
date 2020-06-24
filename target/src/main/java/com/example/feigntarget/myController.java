package com.example.feigntarget;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class myController
{
    private static List< Product > productList = new ArrayList< >();

    static {
        productList.add(new Product(1, "product-1", 12.0));
        productList.add(new Product(2, "product-2", 34.0));
        productList.add(new Product(3, "product-3", 9.0));
    }

    @GetMapping("/products")
    public ResponseEntity <List< Product > > getProducts()
    {
        return ResponseEntity.ok(productList);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity <Object> getProducts(@PathVariable int id)
    {
        return ResponseEntity.ok(findProduct(id));
    }

    private Product findProduct(int id) {
        return productList.stream()
        .filter(user -> user.getId()
        .equals(id))
        .findFirst()
        .orElse(null);
        }
}