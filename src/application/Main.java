package application;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("Enter client data:");
        System.out.printf("Name: ");
        String clientName = sc.nextLine();
        System.out.printf("Email: ");
        String clientEmail = sc.nextLine();
        System.out.printf("Birth Date (DD/MM/YYYY): ");
        Date birthDate = sdf.parse(sc.nextLine());
        System.out.println("Enter order Data: ");
        System.out.printf("Status: ");
        OrderStatus orderStatus = OrderStatus.valueOf(sc.next());
        Order order = new Order(orderStatus,
                new Client(clientName, clientEmail, birthDate));

        System.out.printf("How many items to this order? ");
        int qtOrder = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < qtOrder; i++) {
            System.out.println("Enter #" + (i + 1) + " item data: ");
            System.out.printf("Product name: ");
            String productName = sc.nextLine();
            System.out.printf("Product price: ");
            double productPrice = sc.nextDouble();
            System.out.printf("Quantity: ");
            int productQuantity = sc.nextInt();
            sc.nextLine();
            OrderItem orderItem = new OrderItem(productQuantity,
                    new Product(productName, productPrice));
            order.addItem(orderItem);
        }

        System.out.println("ORDER SUMMARY: ");
        System.out.println(order);
        sc.close();
    }
}
