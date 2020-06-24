package com.sample.feign.FeignSample;

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
    @Autowired
    ITargetClient targetClient;

    @Autowired
    public myController(ITargetClient client) {
        this.targetClient = client;
    }

    @GetMapping("/products")
    public ResponseEntity <List< Product > > getProducts()
    {
        return ResponseEntity.ok(targetClient.getAllProducts());
    }

    @GetMapping("/product/{id}")
    public ResponseEntity <Object> getProducts(@PathVariable int id)
    {
        return ResponseEntity.ok(targetClient.getProduct(id));
    }
}
