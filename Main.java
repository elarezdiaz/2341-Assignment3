
public class Main {
    private RedBlackBST bst = new RedBlackBST();

    public void readProducts(String file) {
        In in = new In(file);
        while (!in.isEmpty()) {
            String line = in.readLine();

            String[] tokens = line.split(",");
            if (tokens.length == 4) {
                String productId = tokens[0];
                String productName = tokens[1];
                String category = tokens[2];
                String price = tokens[3];
                Product product = new Product(productId, productName, category, price);
                bst.insert(product);
            }
        }
    }

    public void searchProducts(String productId) {
        Product product = bst.search(productId);
        if (product != null) {
            System.out.println(product.toString());
        }
    }
    public static void main(String[] args) {
        Main main = new Main();
        main.readProducts("amazon-product-data.csv");

        // adding new example product
        System.out.println("\nProcessing new product:");
        Product newProduct = new Product("1234", "Example Product", "Clothing", "29.99");
        System.out.println(newProduct);
        main.bst.insert(newProduct);
        System.out.println("Product inserted successfully!");
        // duplicate to show error message
        System.out.println("\nProcessing new product:");
        System.out.println(newProduct);
        main.bst.insert(newProduct);

        System.out.println("Enter product ID to search, or 'quit' to exit");

        while (true) {
            System.out.print("\nEnter Product ID: ");
            String requestedProduct = StdIn.readLine().trim();

            if ("quit".equalsIgnoreCase(requestedProduct)) {
                StdOut.println("Exiting program. Thank you!");
                break;
            } else {
                main.searchProducts(requestedProduct);
            }
        }

    }
}
