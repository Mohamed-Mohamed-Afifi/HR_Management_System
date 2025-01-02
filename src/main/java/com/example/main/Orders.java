package com.example.main;

public class Orders {
	private int orderId;

	public Orders() {
		this.orderId=1;
	}
	public Orders(int orderId) {
		this.orderId=orderId;
	}
	public String getOrders() {
		return "All orders from Orders class that injected into Department class using constructor"+orderId;
	}
}
