package createAccount;

import java.sql.SQLException;

import org.cap.exception.InvalidCustomer;
import org.cap.exception.InvalidOpeningBalance;
import org.cap.model.Address;
import org.cap.model.Customer;
import org.cap.service.AccountServiceImpl;
import org.cap.service.IAccountService;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import cucumber.api.java.Before;

public class AccountTest {

	private Customer customer;
	private IAccountService accountService;
	
	
	@Before
	public void setUp()
	{
		customer=new Customer();
		customer.setFirstName("Sarath");
		customer.setLastName("Nistala");
		Address address=new Address();
		address.setDoorName("409");
		address.setCity("Hyderabad");
		customer.setAddress(address);
		accountService=new AccountServiceImpl();
		
	}
	
	@Rule
	public ExpectedException exception=ExpectedException.none();

	@Test
	public void test_customer_with_null() throws InvalidCustomer, InvalidOpeningBalance, SQLException
	{
		customer=null;
		
		exception.expect(InvalidCustomer.class);
		exception.expectMessage("Sorry");
		accountService.createAccount(customer, 1000);
	}
	
	@Test
	public void when_invalid_opening_balance() throws InvalidOpeningBalance, InvalidCustomer, SQLException
	{
		double amount=100;
		exception.expect(InvalidOpeningBalance.class);
		exception.expectMessage("balance");
		accountService.createAccount(customer, amount);

	}
	
}
