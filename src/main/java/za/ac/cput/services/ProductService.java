package za.ac.cput.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Product;
import za.ac.cput.repository.ProductRepository;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ProductService implements IProductService {

    private ProductRepository productRepository;

    @Autowired
    ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    private ProductService() {

    }

    @Override
    public Set<Product> getall() {
        return productRepository.findAll().stream().collect(Collectors.toSet());
    }

    @Override
    public Product create(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product read(String productId) {
        return productRepository.findById(productId).orElse(null);
    }

    @Override
    public Product update(Product product) {
        return productRepository.save(product);
    }
}
