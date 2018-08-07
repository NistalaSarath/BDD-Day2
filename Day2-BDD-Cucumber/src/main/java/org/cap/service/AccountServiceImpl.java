package org.cap.service;

import java.sql.SQLException;

import org.cao.dao.IAccountDao;
import org.cap.exception.InvalidCustomer;
import org.cap.exception.InvalidOpeningBalance;
import org.cap.model.Account;
import org.cap.model.Customer;
import org.cap.util.AccountUtil;

public class AccountServiceImpl implements IAccountService{

	private IAccountDao accountDao;
	
	
	@Override
	public Account createAccount(Customer customer, double openingBalance) throws InvalidCustomer, InvalidOpeningBalance, SQLException{
		
		
		if(customer!=null)
		{
			if(openingBalance>=1000)
			{
				Account account=new Account();
				account.setCustomer(customer);
				account.setOpeningBalance(openingBalance);
				account.setAccountNo(AccountUtil.generateAccountNo());
				
				boolean flag;
					flag = accountDao.addAccount(account);
				
				if(flag)
				{
					return account;
				}
				else {
					return null;
				}
			}
			
			else
			{
				throw new InvalidOpeningBalance("Sorry! invalid opening balance");
			}
		}
		else
		{
			throw new InvalidCustomer("Sorry! Customer refers null");
		}
		

	}

	
	
	
}
