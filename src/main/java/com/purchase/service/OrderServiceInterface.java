package com.purchase.service;

import java.util.List;

import com.purchase.entity.Order;

public interface OrderServiceInterface {
	int addOrder(Order order);
	List<Order> getOrders();
	Order getOrderBySEQ(int seq);
	int modifyOrder(Order order);
	int deleteOrder(int seq);
}
