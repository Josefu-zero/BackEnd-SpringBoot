package com.coltis.ecommerce.services;
 
import com.coltis.ecommerce.dto.ProductRequest;
import com.coltis.ecommerce.exceptions.ResourceNotFoundException;
import com.coltis.ecommerce.models.Product;
import com.coltis.ecommerce.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
 
import java.util.List;
 
@Service
@RequiredArgsConstructor
public class ProductService {
 
    private final ProductRepository productRepository;
 
    public Product createProduct(ProductRequest request) {
        Product product = Product.builder()
                .name(request.name())
                .price(request.price())
                .description(request.description())
                .amount(request.amount())
                .imageUrl(request.imageUrl())
                .build();
 
        return productRepository.save(product);
    }
 
    public Product readProduct(Integer id) {
        return findProductEntity(id);
    }
 
    public List<Product> readAllProducts() {
        return productRepository.findAll();
    }
 
    public Product updateProduct(Integer id, ProductRequest request) {
        Product product = findProductEntity(id);
 
        product.setName(request.name());
        product.setPrice(request.price());
        product.setDescription(request.description());
        product.setAmount(request.amount());
        product.setImageUrl(request.imageUrl());
 
        return productRepository.save(product);
    }
 
    public void deleteProduct(Integer id) {
        Product product = findProductEntity(id);
        productRepository.delete(product);
    }
 
    public Product findProductEntity(Integer id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Producto no encontrado con id: " + id));
    }
}
