package microservices.inventoryservice.Service;

import lombok.RequiredArgsConstructor;
import microservices.inventoryservice.Entity.Inventory;
import microservices.inventoryservice.Repository.InventoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InventoryService {
    private final InventoryRepository inventoryRepository;

    public boolean isInStock(String skuCode, Integer quantity) {
        List<Inventory> inventories = inventoryRepository.findBySkuCode(skuCode);

        int totalQuantity = inventories.stream()
                .mapToInt(Inventory::getQuantity)
                .sum();

        return totalQuantity >= quantity;
    }
}
