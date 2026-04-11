package microservices.inventoryservice.DTO;

public record InventoryRequest(String skuCode, Integer quantity) {
}
