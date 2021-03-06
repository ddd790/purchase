package com.purchase.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.purchase.dao.OrderDao;
import com.purchase.entity.Order;

@Service
public class OrderServiceImpl implements OrderServiceInterface{
	@Autowired
	private OrderDao orderDao;

	@Override
	public int addOrder(Order order) {
		return orderDao.addOrder(order);
	}

	@Override
	public List<Order> getOrders() {
		return orderDao.getOrders();
	}

	@Override
	public Order getOrderBySEQ(int seq) {
		return orderDao.getOrderBySEQ(seq);
	}

	@Override
	public int modifyOrder(Order order) {
		return orderDao.modifyOrder(order);
	}

	@Override
	public int deleteOrder(int seq) {
		return orderDao.deleteOrder(seq);
	}
}
