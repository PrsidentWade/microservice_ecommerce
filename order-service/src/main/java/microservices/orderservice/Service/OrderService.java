package microservices.orderservice.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import microservices.orderservice.Client.InventoryClient;
import microservices.orderservice.DTO.OrderRequest;
import microservices.orderservice.DTO.OrderResponse;
import microservices.orderservice.Entity.Order;
import microservices.orderservice.Repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final InventoryClient inventoryClient;


    public OrderResponse createOrder(OrderRequest request){
        boolean inStock = inventoryClient.isInStock(request.skuCode(), request.quantity());

        if (!inStock) {
            throw new RuntimeException("Stock insuffisant pour : " + request.skuCode());
        }

         Order order = Order.builder()
                 .oderNumber(UUID.randomUUID().toString())
                 .skucode(request.skuCode())
                 .price(request.price())
                 .quantity(request.quantity())
                 .build();
         orderRepository.save(order);
         log.info("Order creeer avec success", order.getOderNumber());
         return  orderBuilder(order);
    }

    public List<OrderResponse> getAll(){
        return orderRepository.findAll()
                .stream()
                .map(this::orderBuilder)
                .toList();
    }
  // Methode private
    private OrderResponse orderBuilder(Order order){
        return OrderResponse.builder()
                .id(order.getId())
                .orderNumber(order.getOderNumber())
                .skuCode(order.getSkucode())
                .price(order.getPrice())
                .quantity(order.getQuantity())
                .build();
    }
}
