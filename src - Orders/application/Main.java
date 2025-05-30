package application;

import model.entities.Client;
import model.entities.Order;
import model.entities.OrderItem;
import model.entities.Product;
import model.entities.enums.OrderStatus;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("Enter client data:");
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("Birth Date (DD/MM/YYYY): ");
        LocalDate birthDate = LocalDate.parse(sc.nextLine(), fmt1);

        Client client = new Client(name, email, birthDate);

        System.out.println("Enter order data:");
        System.out.print("Status: ");
        String orderStatus = sc.nextLine();

        Order order = new Order(LocalDateTime.now(), OrderStatus.valueOf(orderStatus), client);

        System.out.print("How many items to this order? ");
        int quantity = sc.nextInt();
        for (int i = 1; i <= quantity; i++) {
            sc.nextLine();
            System.out.printf("Enter #%d item data: \n", i);
            System.out.print("Product name: ");
            String productName = sc.nextLine();
            System.out.print("Product Price: ");
            double productPrice = sc.nextDouble();

            Product product = new Product(productName, productPrice);

            System.out.print("Quantity: ");
            int prodQuantity = sc.nextInt();

            OrderItem orderItem = new OrderItem(prodQuantity, product);

            order.addItem(orderItem);
        }

        System.out.println();
        System.out.println(order);

        sc.close();
    }
}
