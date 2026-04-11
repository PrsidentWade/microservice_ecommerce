package microservices.productservice.DTO;

import lombok.AllArgsConstructor;

import java.math.BigDecimal;

public record ProductRequest(String id, String name, String description, BigDecimal price) {
}
