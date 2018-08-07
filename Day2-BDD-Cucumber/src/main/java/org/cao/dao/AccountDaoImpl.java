package org.cao.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.cap.exception.InvalidCustomer;
import org.cap.model.Account;

import java.sql.Connection;
/*import com.mysql.jdbc.Connection;
*/
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class AccountDaoImpl implements IAccountDao{

	@Override
	public boolean addAccount(Account account){
		Connection connection =null;

		String sql="Insert into account values(?,?,?)";
			PreparedStatement preparedStatement=null;		
			//ResultSet resultSet = null;

			
			try {
				connection=getMysqlConnection();
				preparedStatement=connection.prepareStatement(sql);
				preparedStatement.setInt(1, account.getAccountNo());
				preparedStatement.setDouble(2, account.getOpeningBalance());
				preparedStatement.setString(3, account.getCustomer().getFirstName());
				int count=preparedStatement.executeUpdate();
				if(count>0)
				{
					return true;
				}
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
			return false;
		} 
		
		
		
		private Connection getMysqlConnection() throws SQLException{
			Connection connection =null;
			
			try {
			
				Class.forName("com.mysql.jdbc.Driver");
				connection=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/springmvcdatabase", "root", "India123");
				
				
				
			}
			catch(ClassNotFoundException e)
			{
				e.printStackTrace();
			
			}	
			return connection;
			
		}	
		
		
	
	
	
	
}
