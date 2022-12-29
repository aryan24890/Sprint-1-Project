package shopping.cart.demo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.shopping_cart.app.model.Customer;
import com.shopping_cart.app.repository.CustomerRepository;
import com.shopping_cart.app.service.CustomerService;

@SpringBootTest
public class CustomerTest {

	@Autowired
	private  CustomerService  customerService;
	
	@MockBean
	private  CustomerRepository  customerRepository;
	
	@Test
	@Order(1)
	@DisplayName(" Testing for creating Customer  ")
	public void  createCustomer() {
		
		Customer customer = new Customer();
		customer.setCustomerNumber(1L);
		customer.setCustomerName("Aryan Raj");
		customer.setContactLastName("Raj");
		customer.setContactFirstName("Aryan");
		customer.setPhone("8404924890");
		customer.setAddressLine1("hinoo,doranda");
		customer.setAddressLine2("ranchi,Jharkhand");
		customer.setCity("Ranchi");
		customer.setState("Jharkhand");
		customer.setPostalCode(834002);
		customer.setCountry("India");
		customer.setSalesRepEmployeeNumber(12L);
		customer.setCreditLimit(156L);
		
		Mockito.when(customerRepository.save(customer))
		.thenReturn(customer);
		
		assertThat(customerService.save(customer))
		.isNotNull();
		
	
		}
	
	@Test
	@Order(2)
	@DisplayName(" Testing for getting customer by last name ")
	public void  getbyLastName() {
		
		Customer customer = new Customer();
		customer.setCustomerNumber(1L);
		customer.setCustomerName("Aryan Raj");
		customer.setContactLastName("Raj");
		customer.setContactFirstName("Aryan");
		customer.setPhone("8404924890");
		customer.setAddressLine1("hinoo,doranda");
		customer.setAddressLine2("ranchi,Jharkhand");
		customer.setCity("Ranchi");
		customer.setState("Jharkhand");
		customer.setPostalCode(834002);
		customer.setCountry("India");
		customer.setSalesRepEmployeeNumber(12L);
		customer.setCreditLimit(156L);
		
		Mockito.when(customerRepository.save(customer))
		.thenReturn(customer);
		
		
	
		}
	
	@Test
	@Order(3)
	@DisplayName(" Testing for deleting Customer by Id  ")
	public void  deleteCustomer() {
		
		Customer customer = new Customer();
		customer.setCustomerNumber(1L);
		customer.setCustomerName("Aryan Raj");
		customer.setContactLastName("Raj");
		customer.setContactFirstName("Aryan");
		customer.setPhone("8404924890");
		customer.setAddressLine1("hinoo,doranda");
		customer.setAddressLine2("ranchi,Jharkhand");
		customer.setCity("Ranchi");
		customer.setState("Jharkhand");
		customer.setPostalCode(834002);
		customer.setCountry("India");
		customer.setSalesRepEmployeeNumber(12L);
		customer.setCreditLimit(156L);
		
		Mockito.when(customerRepository.save(customer))
		.thenReturn(customer);
		
		assertThat(customerService.deleteById(1L))
		.isNotNull();
		
	
		}
	
	@Test
	@Order(4)
	@DisplayName(" Testing for paging ")
	public void  paging() {
		
		Customer customer = new Customer();
		customer.setCustomerNumber(1L);
		customer.setCustomerName("Aryan Raj");
		customer.setContactLastName("Raj");
		customer.setContactFirstName("Aryan");
		customer.setPhone("8404924890");
		customer.setAddressLine1("hinoo,doranda");
		customer.setAddressLine2("ranchi,Jharkhand");
		customer.setCity("Ranchi");
		customer.setState("Jharkhand");
		customer.setPostalCode(834002);
		customer.setCountry("India");
		customer.setSalesRepEmployeeNumber(12L);
		customer.setCreditLimit(156L);
		
		Mockito.when(customerRepository.save(customer))
		.thenReturn(customer);
		
		assertThat(customerService.paging())
		.isNotNull();
		
	
		}
	
	@Test
	@Order(5)
	@DisplayName(" Testing for sorting  ")
	public void  sorting() {
		
		Customer customer = new Customer();
		customer.setCustomerNumber(1L);
		customer.setCustomerName("Aryan Raj");
		customer.setContactLastName("Raj");
		customer.setContactFirstName("Aryan");
		customer.setPhone("8404924890");
		customer.setAddressLine1("hinoo,doranda");
		customer.setAddressLine2("Ranchi,Jharkhand");
		customer.setCity("Ranchi");
		customer.setState("Jharkhand");
		customer.setPostalCode(834002);
		customer.setCountry("India");
		customer.setSalesRepEmployeeNumber(12L);
		customer.setCreditLimit(156L);
		
		Mockito.when(customerRepository.save(customer))
		.thenReturn(customer);
		
		assertThat(customerService.sorting(customer))
		.isNotNull();
		
	
		}
}
