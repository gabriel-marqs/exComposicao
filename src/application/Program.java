package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		

		System.out.println("Enter client data:");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("E-mail: ");
		String email = sc.next();
		System.out.print("Birth Date (DD/MM/YYYY): ");
		Date nascimento = sdf.parse(sc.next());


		Client client = new Client(name, email, nascimento);

		System.out.println("Enter Order Data:");
		System.out.print("Status: ");
		OrderStatus status = OrderStatus.valueOf(sc.next().toUpperCase());

		Order order = new Order(new Date(), status, client);

		System.out.print("How many items to this order? ");
		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			System.out.printf("Enter #%d item data:\n", i + 1);
			System.out.print("Product Name: ");
			sc.nextLine();
			String productName = sc.nextLine();
			System.out.print("Product Price: $");
			double productPrice = sc.nextDouble();
			System.out.print("Quantity: ");
			int quantity = sc.nextInt();

			OrderItem item = new OrderItem(quantity, productPrice, new Product(productName, productPrice));

			order.addItem(item);
		}
		
		System.out.println("ORDER SUMARY:");
		System.out.println(order);
		
	

		sc.close();
	}

}
