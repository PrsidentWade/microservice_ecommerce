package microservices.orderservice.DTO;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
@Builder
public record OrderResponse(
        Long id,
        String orderNumber,
        String skuCode,
        BigDecimal price,
        Integer quantity
) {}
