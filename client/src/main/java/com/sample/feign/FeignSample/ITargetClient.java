package com.sample.feign.FeignSample;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@FeignClient(name = "dummy", url = "http://localhost:9003")
public interface ITargetClient
{
    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public List<Product> getAllProducts();

    @RequestMapping(value = "/product/{id}", method = RequestMethod.GET)
    public Product getProduct(@PathVariable("id") int productId);
}