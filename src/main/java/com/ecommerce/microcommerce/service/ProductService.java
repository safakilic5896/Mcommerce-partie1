package com.ecommerce.microcommerce.service;

import com.ecommerce.microcommerce.dao.ProductDao;
import com.ecommerce.microcommerce.model.Product;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ProductDao productDao;

    public String calculerMargeProduit() {
        List<Product> productList = productDao.findAll();
        Map<String, Integer> map = productList.stream()
                .collect(Collectors.toMap(Product::toString, product -> product.getPrix() - product.getPrixAchat()));
        return new JSONObject(map).toString();
    }
}
