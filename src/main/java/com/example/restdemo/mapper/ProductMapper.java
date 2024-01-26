package com.example.restdemo.mapper;

import com.example.restdemo.model.dto.ProductDto;
import com.example.restdemo.model.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel ="spring")
public interface ProductMapper {

    ProductDto toDTO(Product product);

    Product toEntity(ProductDto productDto);

    List<ProductDto> toDtoList(List<Product> products);

}
