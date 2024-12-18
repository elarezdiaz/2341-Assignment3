public class RedBlackBST<Key extends Comparable<Key>, Value> {
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private class Node {
        Product product;
        Node left, right;
        boolean color;

        Node(Product product, boolean color) {
            this.product = product;
            this.color = color;
        }
    }

    private Node root;

    private Node rotateLeft(Node h) {
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        return x;
    }

    private Node rotateRight(Node h) {
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        return x;
    }

    private void flipColor(Node h) {
        h.color = RED;
        h.left.color = BLACK;
        h.right.color = BLACK;
    }

    private boolean isRed(Node h) {
        return h != null && h.color == RED;
    }

    private Node insert(Node h, Product product) {
        if (h == null) {
            return new Node(product, RED);
        }

        int cmp = product.getProductId().compareTo(h.product.getProductId());
        if (cmp < 0) h.left = insert(h.left, product);
        else if (cmp > 0) h.right = insert(h.right, product);
        else {
            System.out.println("Error: Product already exists.");
            return h;
        }
        if (isRed(h.right) && !isRed(h.left)) h = rotateLeft(h);
        if (isRed(h.left) && isRed(h.left.left)) h = rotateRight(h);
        if (isRed(h.left) && isRed(h.right)) flipColor(h);

        return h;
    }

    public void insert(Product product) {
        root = insert(root, product);
        root.color = BLACK;
    }

    public Product search(String productId) {
        Node h = search(root, productId);
        if (h != null) return h.product;
        else {
            System.out.println("Error: Product not found.");
            return null;
        }
    }

    private Node search(Node h, String productId) {
        while (h != null) {
            int cmp = productId.compareTo(h.product.getProductId());
            if (cmp < 0) h = h.left;
            else if (cmp > 0) h = h.right;
            else return h;
        }
        return null;
    }
}