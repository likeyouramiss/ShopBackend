package web.market.me.serivce;

import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;
import web.market.me.dto.request.ProductRequest;
import web.market.me.entity.Product;
import web.market.me.entity.User;
import web.market.me.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService (ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product createProduct(ProductRequest productRequest){
        Product product = new Product();

        product.setName(productRequest.getName());
        product.setDescription(productRequest.getDescription());
        product.setPrice(productRequest.getPrice());

        return productRepository.save(product);
    }

    public List<Product> getAllProduct(){
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    public Product updateProduct(Long id, ProductRequest productRequest) {
        Product updateProduct = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));

        updateProduct.setName(productRequest.getName());
        updateProduct.setDescription(productRequest.getDescription());
        updateProduct.setPrice(productRequest.getPrice());


        return productRepository.save(updateProduct);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

}
