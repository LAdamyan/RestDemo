package com.example.restdemo.service;

import com.example.restdemo.exception.ResourceNotFoundException;
import com.example.restdemo.mapper.ProductMapper;
import com.example.restdemo.model.dto.ProductDto;
import com.example.restdemo.model.entity.Product;
import com.example.restdemo.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public ProductServiceImpl(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    @Override
    public List<ProductDto> getAllProducts() {
       List<Product> products = productRepository.findAll();
       return productMapper.toDtoList(products);
    }

    @Override
    public ProductDto getProductById(long id) {
        Product product = productRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
        return productMapper.toDTO(product);
    }

    @Override
    public void deleteProductById(long id) {
        productRepository.deleteById(id);

    }

    @Override
    public ProductDto addProduct(ProductDto product) {
       Product productEntity = productMapper.toEntity(product);
       Product save = productRepository.save(productEntity);
       return productMapper.toDTO(save);
    }
}
