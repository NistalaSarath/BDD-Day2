package createAccount;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.cap.exception.InvalidCustomer;
import org.cap.exception.InvalidOpeningBalance;
import org.cap.model.Account;
import org.cap.model.Address;
import org.cap.model.Customer;
import org.cap.service.AccountServiceImpl;
import org.cap.service.IAccountService;

import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDef {

	private Customer customer;
	private double openingBalance;
	
	private IAccountService accountService;
	
	private Account account;
	
	@Before
	public void setUp()
	{
		customer=new Customer();
		openingBalance=1000;
		accountService=new AccountServiceImpl();
	}
	
	@Given("^customer details$")
	public void customer_details() throws Throwable {
	   
		customer.setFirstName("Pravalika");
		customer.setLastName("Nayana");
		Address address=new Address();
		address.setDoorName("756/1");
		address.setCity("Hyderabad");
		
		
	}

	@When("^valid customer$")
	public void valid_customer() throws Throwable {
	   
		assertNotNull(customer);
	}

	@When("^valid opening balance$")
	public void valid_opening_balance() throws Throwable {
	   
		assertTrue(openingBalance>=1000);
	}

	@Then("^create new account$")
	public void create_new_account() throws Throwable {
	    
		//Bussiness Logic
		account=accountService.createAccount(customer, openingBalance);
		assertNotNull(account);
		assertEquals(openingBalance,account.getOpeningBalance(),0.0);
		assertEquals(1, account.getAccountNo());
		
	}

	@Given("^Customer details$")
	public void customer_details1() throws Throwable {
	   customer=null;
	}

	@When("^Invalid customer$")
	public void invalid_customer() throws Throwable {
	    /*assertNull(customer);*/
		assertNull(customer);
	}

	@Then("^throw 'Invalid Customer' error message$")
	public void throw_Invalid_Customer_error_message() throws Throwable {
	   
		/*assertNull(accountService.createAccount(customer, 1000));*/
		
		try {
			accountService.createAccount(customer, 1000);
			
		}
		catch(InvalidCustomer e)
		{
			
		}
	}

	@Given("^customer details and opening balance$")
	public void customer_details_and_opening_balance() throws Throwable {
	    openingBalance=100;
	}

	@When("^invalid opening balance$")
	public void invalid_opening_balance() throws Throwable {
	    
		assertTrue(openingBalance<1000);
	}

	@Then("^throw 'Insufficient Balance' error message$")
	public void throw_Insufficient_Balance_error_message() throws Throwable {
	   
		try
		{
			accountService.createAccount(customer, 1000);
			
		}
		catch(InvalidOpeningBalance e)
		{
			
		}
		
	}
}
