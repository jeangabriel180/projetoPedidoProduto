package entities;

import entities.enums.OrderStatus;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
    private Date moment = new Date();
    private OrderStatus status;
    private List<OrderItem> orderItems = new ArrayList<>();
    private Client client;
    private StringBuilder builder = new StringBuilder();
    private SimpleDateFormat sdfDateHour = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    public Order(OrderStatus status, Client client) {
        this.status = status;
        this.client = client;
    }

    public Date getMoment() {
        return moment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void addItem(OrderItem item) {
        orderItems.add(item);
    }

    public void removeItem(OrderItem item) {
        orderItems.remove(item);
    }

    public Double total() {
        double sum = 0.0;
        for (OrderItem item : orderItems) {
            sum += item.subTotal();
        }
        return sum;
    }

    public String toString() {

        String items = "";
        for (OrderItem item : orderItems) {
            items += item.toString() + "\n";
        }

        String summary = builder
                .append("Order moment: " + sdfDateHour.format(getMoment()) + "\n")
                .append("Order status: " + getStatus() + "\n")
                .append("Client: " + client)
                .append("Order items: \n")
                .append(items)
                .append("Total price: $" + String.format("%.2f", total()))
                .toString();

        return summary;
    }
}
