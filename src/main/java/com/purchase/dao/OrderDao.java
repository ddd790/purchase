package com.purchase.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.purchase.Utils;
import com.purchase.entity.Order;

@Repository
public class OrderDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public int addOrder(Order order) {
		String sql = "INSERT INTO orders (PROJECT_CODE,TITLE,COMPANY_NAME,CUSTOMER_COMPANY_CODE,CUSTOMER_USER_CODE,"
				+ "CONTRACT_CODE,CONTRACT_DATE,CONTRACT_USER_CODE,ORDERED_FLG,CONFIRMER_USER_CODE,REMARKS,REGISTER_DATE,"
				+ "REGISTER_USER_NAME,UPDATE_DATE,UPDATE_USER_NAME,DELETE_FLG) "
				+ "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		return jdbcTemplate.update(sql, order.getPROJECT_CODE(), order.getTITLE(), order.getCOMPANY_NAME(),
				order.getCUSTOMER_COMPANY_CODE(), order.getCUSTOMER_USER_CODE(), order.getCONTRACT_CODE(),
				order.getCONTRACT_DATE(), order.getCONTRACT_USER_CODE(), order.getORDERED_FLG(),
				order.getCONFIRMER_USER_CODE(), order.getREMARKS(), order.getREGISTER_DATE(),
				order.getREGISTER_USER_NAME(), order.getUPDATE_DATE(), order.getUPDATE_USER_NAME(),
				order.getDELETE_FLG());
	}

	public List<Order> getOrders() {
		String sql = "select * from orders where DELETE_FLG = 0";
		return jdbcTemplate.query(sql, new OrderRowMapper());
	}

	public Order getOrderBySEQ(int seq) {
		String sql = "select * from orders where SEQ = " + seq;
		List<Order> result = jdbcTemplate.query(sql, new OrderRowMapper());
		return Utils.isNullList(result) ? null : result.get(0);
	}

	public int modifyOrder(Order order) {
		String sql = "update orders set PROJECT_CODE = ?,TITLE = ?,COMPANY_NAME = ?,CONTRACT_USER_CODE = ? where SEQ = ?";
		return jdbcTemplate.update(sql, order.getPROJECT_CODE(), order.getTITLE(), order.getCOMPANY_NAME(),
				order.getCONFIRMER_USER_CODE(), order.getSEQ());
	}
	
	public int deleteOrder(int seq) {
		String sql = "update orders set DELETE_FLG = 1 where SEQ = ?";
		return jdbcTemplate.update(sql, seq);
	}

	class OrderRowMapper implements RowMapper<Order> {
		@Override
		public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
			// 对数据的返回处理
			Order order = new Order();
			order.setSEQ(rs.getInt("SEQ"));
			order.setPROJECT_CODE(rs.getString("PROJECT_CODE"));
			order.setTITLE(rs.getString("TITLE"));
			order.setCOMPANY_NAME(rs.getString("COMPANY_NAME"));
			return order;
		}
	}
}
