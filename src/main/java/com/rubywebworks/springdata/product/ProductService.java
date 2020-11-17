package com.rubywebworks.springdata.product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

  @Autowired
  private ProductRepository productRepository;

  public List<Product> getAllProducts() {
    List<Product> products = new ArrayList<>();

    productRepository.findAll().forEach(products::add);

    return products;
  }

  public void addProduct(Product product) {
    productRepository.save(product);
  }

  public Optional<Product> getProduct(Long id) {
    return productRepository.findById(id);
  }
}
