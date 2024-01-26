package com.example.restdemo.model.response;

import com.example.restdemo.model.dto.ProductDto;

import java.util.List;

public class ProductResponse {

    private List<ProductDto> productList;

    public ProductResponse(List<ProductDto> productList) {
        this.productList = productList;
    }

    public List<ProductDto> getProductList() {
        return productList;
    }

    public void setProductList(List<ProductDto> productList) {
        this.productList = productList;
    }
}
