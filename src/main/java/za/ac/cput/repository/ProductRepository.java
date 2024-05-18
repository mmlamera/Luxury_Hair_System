package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.Product;

public interface ProductRepository extends JpaRepository<Product, String> {

    Product findProductByProductId(String productId);

    void deleteProductByHairTexture(String hairTexture);
    void deleteProductByHairStyle(String hairStyle);


}
