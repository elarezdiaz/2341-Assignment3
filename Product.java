public class Product {
    private String productName;
    private String productId;
    private String category;
    private String price;

    public Product(String productId, String productName, String category, String price) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
        this.price = price;
    }

    public String getProductId() {
        return productId;
    }

    public String toString() {
        return "Product ID: " + productId + ", Name: " + productName + ", Category: " + category + ", Price: $" + price;
    }
}
