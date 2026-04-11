package microservices.orderservice.Controller;

import lombok.RequiredArgsConstructor;
import microservices.orderservice.DTO.OrderRequest;
import microservices.orderservice.DTO.OrderResponse;
import microservices.orderservice.Service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @GetMapping("/all")
    public List<OrderResponse> getAll(){
        return orderService.getAll();
    }
    @PostMapping()
    public OrderResponse create(@RequestBody OrderRequest request){
        return orderService.createOrder(request);
    }
}
