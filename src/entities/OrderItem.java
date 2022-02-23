package entities;

public class OrderItem {
    private Integer quantity;
    private Product product;

    public OrderItem(Integer quantity, Product product) {
        this.quantity = quantity;
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Double subTotal() {
        return quantity * getProduct().getPrice();
    }

    public String toString() {
        return getProduct().getName() + ", $" +
                String.format("%.2f", getProduct().getPrice()) +
                ", Quantity: " + getQuantity() + ", Subtotal: $" +
                String.format("%.2f", subTotal());
    }
}
