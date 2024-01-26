package com.example.restdemo.controller;

import com.example.restdemo.model.dto.ProductDto;
import com.example.restdemo.model.response.ProductResponse;
import com.example.restdemo.service.ProductService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1")
public class ProductController {
    private final ProductService productService;


    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    @ApiOperation("Get all products list from database")
    public ResponseEntity<ProductResponse> getAllProducts() {
        return ResponseEntity.ok(new ProductResponse(productService.getAllProducts()));
    }
    @GetMapping("/products/{id}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable(name="id")int id){
        return ResponseEntity.ok(productService.getProductById(id));

    }
    @DeleteMapping("/products/{id}")
    public void deleteProductById(@PathVariable(name="id")int id){
        productService.deleteProductById(id);
    }

    @PostMapping("/products")
    public ResponseEntity<ProductDto> addProduct(@RequestBody ProductDto product){
        ProductDto productDto = productService.addProduct(product);
        return ResponseEntity.ok(productDto);
    }

}
