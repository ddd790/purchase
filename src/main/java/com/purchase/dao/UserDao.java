package com.purchase.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.purchase.entity.User;

@Repository
public class UserDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void addUser(User user) {
		String sql = "INSERT INTO users (MAIL_ADDRESS,PASSWORD,USER_NAME,AUTHORITY_KIND,REGISTER_DATE,REGISTER_USER_NAME,UPDATE_DATE,UPDATE_USER_NAME,DELETE_FLG) "
				+ "VALUES(?,?,?,null,null,null,null,null,null)";
		jdbcTemplate.update(sql, user.getMAIL_ADDRESS(), user.getPASSWORD(), user.getUSER_NAME());
	}
}
