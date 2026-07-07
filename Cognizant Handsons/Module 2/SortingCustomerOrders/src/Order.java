package src;

/**
 * Order - represents a customer order.
 */
public class Order {

    private int    orderId;
    private String customerName;
    private double totalPrice;

    public Order(int orderId, String customerName, double totalPrice) {
        this.orderId      = orderId;
        this.customerName = customerName;
        this.totalPrice   = totalPrice;
    }

    public int    getOrderId()      { return orderId; }
    public String getCustomerName() { return customerName; }
    public double getTotalPrice()   { return totalPrice; }

    @Override
    public String toString() {
        return String.format("Order { id=%-4d customer=%-15s total=$%.2f }",
                orderId, customerName, totalPrice);
    }
}
