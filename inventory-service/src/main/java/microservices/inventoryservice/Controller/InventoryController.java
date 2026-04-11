package microservices.inventoryservice.Controller;

import lombok.RequiredArgsConstructor;
import microservices.inventoryservice.Service.InventoryService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryService inventoryService;

    @GetMapping("/{skuCode}")
    public boolean isInStock(
            @PathVariable String skuCode,
            @RequestParam Integer quantity
    ) {
        return inventoryService.isInStock(skuCode, quantity);
    }
}
