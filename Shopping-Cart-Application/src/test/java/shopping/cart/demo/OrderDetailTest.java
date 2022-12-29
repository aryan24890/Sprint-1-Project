package shopping.cart.demo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Order;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.shopping_cart.app.model.OrderDetail;
import com.shopping_cart.app.repository.OrderDetailRepository;
import com.shopping_cart.app.service.OrderDetailService;

@SpringBootTest
public class OrderDetailTest {

	@Autowired
	private  OrderDetailService  orderDetailService;
	
	@MockBean
	private  OrderDetailRepository  orderDetailRepository;
	
	@Test
	@Order(1)
	@DisplayName(" Testing for creating OrderDetail record  ")
	public void  createOrderDetail() {
		OrderDetail orderDetail = new OrderDetail();
		orderDetail.setOrderNumber(1L);
		orderDetail.setQuantityOrdered(123L);
		orderDetail.setPriceEach(234.78);
		orderDetail.setOrderLineNumber(123L);
		
		Mockito.when(orderDetailRepository.save(orderDetail))
		.thenReturn(orderDetail);
		
		assertThat(orderDetailService.save(orderDetail))
		.isNotNull();

	}
	
	@Test
	@Order(2)
	@DisplayName(" Testing for getting OrderDetail record by Id ")
	public void  getById() {
		OrderDetail orderDetail = new OrderDetail();
		orderDetail.setOrderNumber(1L);
		orderDetail.setQuantityOrdered(123L);
		orderDetail.setPriceEach(234.78);
		orderDetail.setOrderLineNumber(123L);
		
		Mockito.when(orderDetailRepository.save(orderDetail))
		.thenReturn(orderDetail);
		
		assertThat(orderDetailService.getById(1L))
		.isNull();

	}
	
	
	@Test
	@Order(3)
	@DisplayName(" Testing for paging ")
	public void  paging() {
		OrderDetail orderDetail = new OrderDetail();
		orderDetail.setOrderNumber(1L);
		orderDetail.setQuantityOrdered(123L);
		orderDetail.setPriceEach(234.78);
		orderDetail.setOrderLineNumber(123L);
		
		Mockito.when(orderDetailRepository.save(orderDetail))
		.thenReturn(orderDetail);
		
		assertThat(orderDetailService.paging())
		.isNotNull();

	}
	
	@Test
	@Order(4)
	@DisplayName(" Testing for deleting by Id ")
	public void  deletebyId() {
		OrderDetail orderDetail = new OrderDetail();
		orderDetail.setOrderNumber(1L);
		orderDetail.setQuantityOrdered(123L);
		orderDetail.setPriceEach(234.78);
		orderDetail.setOrderLineNumber(123L);
		
		Mockito.when(orderDetailRepository.save(orderDetail))
		.thenReturn(orderDetail);
		
		assertThat(orderDetailService.deleteById(1L))
		.isNotNull();

	}
	
	@Test
	@Order(5)
	@DisplayName(" Testing for sorting ")
	public void  sorting() {
		OrderDetail orderDetail = new OrderDetail();
		orderDetail.setOrderNumber(1L);
		orderDetail.setQuantityOrdered(123L);
		orderDetail.setPriceEach(234.78);
		orderDetail.setOrderLineNumber(123L);
		
		Mockito.when(orderDetailRepository.save(orderDetail))
		.thenReturn(orderDetail);
		
		assertThat(orderDetailService.sorting(orderDetail))
		.isNotNull();

	}
}
