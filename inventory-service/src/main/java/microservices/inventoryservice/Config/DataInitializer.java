package microservices.inventoryservice.Config;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import microservices.inventoryservice.Entity.Inventory;
import microservices.inventoryservice.Repository.InventoryRepository;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataInitializer {

    private final InventoryRepository inventoryRepository;

    @PostConstruct
    public void init() {


        if (inventoryRepository.findBySkuCode("MACBOOK-PRO-14").isEmpty()) {
            Inventory product1 = new Inventory();
            product1.setSkuCode("MACBOOK-PRO-14");
            product1.setQuantity(100);
            inventoryRepository.save(product1);
        }

        if (inventoryRepository.findBySkuCode("IPHONE-15").isEmpty()) {
            Inventory product2 = new Inventory();
            product2.setSkuCode("IPHONE-15");
            product2.setQuantity(5);
            inventoryRepository.save(product2);
        }

        System.out.println("✅ Données Inventory ajoutées !");
    }
}