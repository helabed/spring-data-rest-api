package com.rubywebworks.springdata.product;

import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
  // only implements what is special
}
