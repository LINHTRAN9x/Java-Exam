package Product;

public class Product {
    int productId;
    String productName = "";
    Float productPrice;
    int qty;
    String category;
    /////Constructor//////
    public Product(int productId, String productName, Float productPrice, int qty, String category) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.qty = qty;
        this.category = category;
    }
    
    //Methods
    public void UpQty(int amount) {
        this.qty += amount;
    }
    
    public void downQty(int amount) {
        if (amount <= this.qty) {
            this.qty -= amount;
        } else {
            System.out.println("Not enough stock to reduce.");
        }
    }

    public void changePrice(float newPrice) {
        this.productPrice = newPrice;
    }

    public void checkStockStatus() {
        if (this.qty > 0) {
            System.out.println(">>STOCKING<<");
        } else {
            System.out.println(">>OUT OF STOCK<<");
        }
    }

    ////////////////
    public void displayProductInfo() {
        System.out.println("ProductID: " + productId);
        System.out.println("Name: " + productName);
        System.out.println("Price: $" + productPrice );
        System.out.println("Quantity: " + qty);
        System.out.println("Category: " + category);
    }
}
