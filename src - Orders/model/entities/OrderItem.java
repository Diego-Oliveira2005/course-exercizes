package model.entities;

public class OrderItem {
    private Integer quantity;
    private Double price;

    private Product product;

    public OrderItem(Integer quantity, Product product) {
        this.quantity = quantity;
        this.price = product.getPrice();
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Double subTotal() {
        return price * quantity;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(product);
        sb.append(", Quantity: ");
        sb.append(quantity);
        sb.append(", Subtotal: $");
        sb.append(subTotal());
        return sb.toString();
    }
}
