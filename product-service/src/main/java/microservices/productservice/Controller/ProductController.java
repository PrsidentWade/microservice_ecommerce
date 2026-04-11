package microservices.productservice.Controller;

import lombok.RequiredArgsConstructor;
import microservices.productservice.DTO.ProductRequest;
import microservices.productservice.DTO.ProductResponse;
import microservices.productservice.Service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductResponse createProduct(@RequestBody ProductRequest request){
          return productService.creteProduct(request);
    }
    @GetMapping("all")
    public List<ProductResponse> getAll(){
        return productService.getAllProducts();
    }
}
