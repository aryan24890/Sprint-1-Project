package shopping.cart.demo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.junit.jupiter.api.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.shopping_cart.app.model.Product;
import com.shopping_cart.app.repository.ProductRepository;
import com.shopping_cart.app.service.ProductService;

@SpringBootTest
public class ProductTest {

	@Autowired
	private ProductService productService;
	
	@MockBean
	private ProductRepository productRepository;
	 
	@Test
	@Order(1)
	@DisplayName(" Testing for creating Product  ")
	public void  createProduct() {
		Product product = new Product();

		product.setProductCode(1L);
		product.setProductName("Horlicks");
		product.setProductScale("Protein plus");
		product.setProductVendor("B.Rao");
		product.setQuantityInStock(500);
		product.setBuyPrice(180.00);
		product.setMsrp(220.79);
		
		Mockito.when(productRepository.save(product)).
		thenReturn(product);
		assertThat(productService.save(product)).
		isNotNull();
	}
	
	@Test
	@Order(2)
	@DisplayName(" Testing for getting Product by Id ")
	public void  getProductById() {
		Product product = new Product();

		product.setProductCode(1L);
		product.setProductName("Horlicks");
		product.setProductScale("Protein plus");
		product.setProductVendor("B.Rao");
		product.setQuantityInStock(500);
		product.setBuyPrice(180.00);
		product.setMsrp(220.79);
		
		Mockito.when(productRepository.save(product)).
		thenReturn(product);
		assertThat(productService.getById(1L)).
		isNull();
	}
	
	@Test
	@Order(3)
	@DisplayName(" Testing for deleting Product  ")
	public void  deleteProduct() {
		Product product = new Product();

		product.setProductCode(1L);
		product.setProductName("Horlicks");
		product.setProductScale("Protein plus");
		product.setProductVendor("B.Rao");
		product.setQuantityInStock(500);
		product.setBuyPrice(180.00);
		product.setMsrp(220.79);
		
		Mockito.when(productRepository.save(product)).
		thenReturn(product);
		assertThat(productService.deleteById(1L)).
		isNotNull();
	}
	
	@Test
	@Order(4)
	@DisplayName(" Testing for paging  ")
	public void  paging() {
		Product product = new Product();

		product.setProductCode(1L);
		product.setProductName("Horlicks");
		product.setProductScale("Protein plus");
		product.setProductVendor("B.Rao");
		product.setQuantityInStock(500);
		product.setBuyPrice(180.00);
		product.setMsrp(220.79);
		
		Mockito.when(productRepository.save(product)).
		thenReturn(product);
		assertThat(productService.paging()).
		isNotNull();
	}
	
	@Test
	@Order(5)
	@DisplayName(" Testing for paging  ")
	public void  sorting() {
		Product product = new Product();

		product.setProductCode(1L);
		product.setProductName("Horlicks");
		product.setProductScale("Protein plus");
		product.setProductVendor("B.Rao");
		product.setQuantityInStock(500);
		product.setBuyPrice(180.00);
		product.setMsrp(220.79);
		
		Mockito.when(productRepository.save(product)).
		thenReturn(product);
		assertThat(productService.sorting(product)).
		isNotNull();
	}
}
