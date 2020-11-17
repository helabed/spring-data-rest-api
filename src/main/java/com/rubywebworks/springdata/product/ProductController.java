package com.rubywebworks.springdata.product;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

  @Autowired   // marks this instance as needing to be dependency injected into this class.
  private ProductService productService;

  @RequestMapping("/products") // mapping /topics web url to this method getAllTopics(), defaults to GET method.
                             // Spring MVC auto magically converts the List<Topic> into JSON and returns it to the
                             // caller, in this case the web browser.
  public List<Product> getAllProducts() {
    return productService.getAllProducts();
  }

//  @RequestMapping("/products/{productId}")
//  public Product getProduct(@PathVariable("productId") String id) {
//    return productService.getProduct(id);
//  }

  // Example of a curl command to produce a POST
  // curl -H "Accept: text/json" -H "Content-type: application/json" -d \
  //   "{\"id\":10000,\"title\":\"Ruby on Rails\",\"description\":\"Introduction to Rails\",\"price\":12.6}" \
  //   http://localhost:8080/products
  @RequestMapping(method=RequestMethod.POST, value="/products")
  public void addProduct(@RequestBody Product product) {
    productService.addProduct(product);
  }
//
//  // Example of a curl command to produce a PUT
//  // curl -X PUT -H "Accept: text/json" -H "Content-type: application/json" -d \
//  //   "{\"id\":\"ruby\",\"title\":\"Ruby on Rails\",\"description\":\"Introduction to Ruby on Rails\"}" \
//  //   http://localhost:8080/products/100
//  @RequestMapping(method=RequestMethod.PUT, value="/products/{id}")
//  public void updateProduct(@RequestBody Product product, @PathVariable String id) {
//    productService.updateProduct(id, product);
//  }
//
//  // Example of a curl command to produce a DELETE
//  // curl -X DELETE -H "Accept: text/json" -H "Content-type: application/json" http://localhost:8080/products/100
//  @RequestMapping(method=RequestMethod.DELETE, value="/products/{id}")
//  public void deleteProduct(@PathVariable String id) {
//    productService.deleteProduct(id);
//  }
}
