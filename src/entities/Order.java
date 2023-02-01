package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
	private Date moment;
	private OrderStatus status;
	
	private Client client;
	
	private List<OrderItem> items = new ArrayList<>();
	
	public Order() {
		
	}

	public Order(Date moment, OrderStatus status, Client client) {
		this.moment = moment;
		this.status = status;
		this.client = client;
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<OrderItem> getItems() {
		return items;
	}
	public void addItem(OrderItem orderItem) {
		items.add(orderItem);
	}
	public void removeItem(OrderItem orderItem) {
		items.remove(orderItem);
	}
	
	public double total() {
		double soma = 0;
		for (OrderItem o : items) {
			soma += o.subTotal();
		}
		return soma;
		
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("Order moment: ");
		sb.append(sdf.format(moment) + "\n");
		sb.append("Order Status: ");
		sb.append(status + "\n");
		sb.append("Client: ");
		sb.append(client + "\n");
		sb.append("Order items:\n");
		
		for (OrderItem o : items) {
			sb.append(o.getProduct().getName() + ", $");
			sb.append(String.format("%.2f", o.getProduct().getPrice()) + ", ");
			sb.append("Quantity: " + o.getQuantity());
			sb.append(", Subtotal: $" + String.format("%.2f", o.subTotal()));
			sb.append("\n");
		}
		sb.append("\nTotal price: $" + String.format("%.2f", total()));
		
		
		
		return sb.toString();
	}
	
	
	
	

}
