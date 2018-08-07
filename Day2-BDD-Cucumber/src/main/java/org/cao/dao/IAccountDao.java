package org.cao.dao;

import java.sql.SQLException;

import org.cap.model.Account;

import com.mysql.jdbc.Connection;

public interface IAccountDao {

	public boolean addAccount(Account account) throws SQLException;
	
}
