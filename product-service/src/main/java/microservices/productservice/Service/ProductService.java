package microservices.productservice.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import microservices.productservice.DTO.ProductRequest;
import microservices.productservice.DTO.ProductResponse;
import microservices.productservice.Entity.Product;
import microservices.productservice.Repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public ProductResponse creteProduct(ProductRequest request){
        Product product = Product.builder()
                .name(request.name())
                .description(request.description())
                .price(request.price())
                .build();
        productRepository.save(product);
        log.info("Product created avec succes");
        return productBuilder(product);
    }

    public List<ProductResponse> getAllProducts() {
        return  productRepository.findAll()
                .stream()
                .map(this::productBuilder)
                .toList();
    }

    private ProductResponse productBuilder(Product product){
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
    }

}
