package com.example.restdemo.service;

import com.example.restdemo.model.dto.ProductDto;

import java.util.List;

public interface ProductService {

    List<ProductDto> getAllProducts();

    ProductDto getProductById(long id);

    void deleteProductById(long id);

    ProductDto addProduct(ProductDto product);

}
