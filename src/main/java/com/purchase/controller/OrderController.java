package com.purchase.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.purchase.entity.Order;
import com.purchase.service.OrderServiceImpl;

@Controller
public class OrderController {
	@Autowired
	private OrderServiceImpl orderService;
	
	@RequestMapping(value = "showOrders", method = RequestMethod.GET)
	public String showOrders(Model model) {
		model.addAttribute("orders", orderService.getOrders());
		return "order_list";
	}
	
	@GetMapping("/addOrder")
	public String addOrderForm(Model model) {
		model.addAttribute("order", new Order());
		return "order_add";
	}
	
	@PostMapping("/addOrder")
	public String addOrderSubmit(@ModelAttribute Order order) {
		int i = orderService.addOrder(order);
		return i > 0 ? "success" : "failed";
	}
	
	@RequestMapping(value = "modifyOrder", method = RequestMethod.GET)
	public String modifyOrderForm(Model model, int seq) {
		Order order = orderService.getOrderBySEQ(seq);
		model.addAttribute("order", order);
		return "order_modify";
	}
	
	@PostMapping("/modifyOrder")
	public String modifyOrderSubmit(@ModelAttribute Order order, String seq) {
		order.setSEQ(Integer.parseInt(seq));
		int i = orderService.modifyOrder(order);
		return i > 0 ? "success" : "failed";
	}
	
	@RequestMapping(value = "deleteOrder", method = RequestMethod.GET)
	public String deleteOrder(String seq) {
		int i = orderService.deleteOrder(Integer.parseInt(seq));
		return i > 0 ? "success" : "failed";
	}
}
