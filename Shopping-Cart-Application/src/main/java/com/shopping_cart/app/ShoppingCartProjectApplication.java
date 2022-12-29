package com.shopping_cart.app;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.shopping_cart.app.controller.CustomerController;
import com.shopping_cart.app.controller.EmployeeController;
import com.shopping_cart.app.controller.OfficeController;
import com.shopping_cart.app.controller.OrderController;
import com.shopping_cart.app.controller.OrderDetailController;
import com.shopping_cart.app.controller.PaymentController;
import com.shopping_cart.app.controller.ProductController;
import com.shopping_cart.app.controller.ProductLineController;
import com.shopping_cart.app.model.Customer;
import com.shopping_cart.app.model.Employee;
import com.shopping_cart.app.model.Office;
import com.shopping_cart.app.model.Order;
import com.shopping_cart.app.model.OrderDetail;
import com.shopping_cart.app.model.Payment;
import com.shopping_cart.app.model.Product;
import com.shopping_cart.app.model.ProductLine;


@SpringBootApplication
public class ShoppingCartProjectApplication implements CommandLineRunner {
	
	@Autowired
	private ProductController productController;
	
	@Autowired
	private ProductLineController productLineController;
	
	@Autowired
	private OfficeController officeController;
	
	@Autowired
	private EmployeeController employeeController;
	
	@Autowired
	private OrderController orderController;
	
	@Autowired
	private OrderDetailController orderDetailController;
	
	@Autowired
	private PaymentController paymentController;
	
	@Autowired
	private CustomerController customerController;
	
	public static void main(String[] args) {
		SpringApplication.run(ShoppingCartProjectApplication.class, args);
	  	
	}
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println("=============================================");
		System.out.println("              Products Records               ");
		System.out.println("=============================================");
		addProducts(createProducts());
		
		System.out.println("=============================================");
		System.out.println("              productLines Records           ");
		System.out.println("=============================================");
		addProductLine(createProductLines());
		
		System.out.println("=============================================");
		System.out.println("                 Orders Records              ");
		System.out.println("=============================================");
		addOrder(createOrder());
		
		System.out.println("=============================================");
		System.out.println("                OrderDetails Records         ");
		System.out.println("=============================================");
		addOrderDetail(createOrderDetail());
		
		System.out.println("=============================================");
		System.out.println("                 Customers Records           ");
		System.out.println("=============================================");
		addCustomer(createCustomer());
		
		System.out.println("=============================================");
		System.out.println("                 Payments Records            ");
		System.out.println("=============================================");
		addPayment(createPayment());
		
		System.out.println("=============================================");
		System.out.println("                 Employees Records           ");
		System.out.println("=============================================");
		addEmployee(createEmployee());
		
		System.out.println("=============================================");
		System.out.println("                 Offices Records             ");
		System.out.println("=============================================");
		addOffice(createOffice());
		
	}

	private void addProducts(List<Product> products) {
		for (Product product : products) {
			productController.createProduct(product);
			
		}
	}
	
	
	private void addProductLine(List<ProductLine> productLines) {
		for (ProductLine productLine : productLines) {
			productLineController.createProductLine(productLine);
			}
		}
	
	private void addCustomer(List<Customer> customers) {
		for (Customer customer :customers) {
			customerController.createCustomer(customer);
			}
		}
	
	private void addOrder(List<Order> orders) {
		for (Order order :orders) {
			orderController.createOrder( order);
		}
	}
	
	private void addOrderDetail(List<OrderDetail> orderDetails) {
		for (OrderDetail orderDetail :orderDetails) {
			orderDetailController.createOrderDetail( orderDetail);
		}
	}
	
	private void addPayment(List<Payment> payments) {
		for (Payment payment :payments) {
			paymentController.createPayment(payment);
		}
	}
	
	private void addEmployee(List<Employee> employees) {
		for (Employee employee :employees) {
			employeeController.createEmployee(employee);
		}
	}
	

	private void addOffice(List<Office> offices) {
		for (Office office :offices) {
			officeController.createOffice(office);
		}
	}
	
	private List<Product> createProducts() {
		//create object
				
				Product product1 = new  Product(1L,"Horlicks ","Nestlé  ranks second in the Food and Agriculture Benchmark ",
						"amitabh chakrabati","No matter where you go in India, no matter how remote a village, "
						+ "Horlicks helps your toddler with complete nutrition.",150,135.10,293.34,null,null);		
						
				Product product2 = new  Product(2L,"ManGrow","Nestlé  ranks second in the Food and Agriculture Benchmark ",
						"Taruna-Dev","Nestle NANGROW™ is a Nutritious Health Drink For Kids growth & development.",189,499.04,
						640.11,null,null);			
								
				Product product3 = new  Product(3L,"dark-cream","Nivea  ranked fourth ", "Taruna Enterprises",
						"Nivea men dark spot reduction creme.",189,259.10,375.22,null,null);
				
				Product product4 = new  Product(4L,"Fresh-Cream","Amul becomes World's 8th Largest Milk Processor",
						"Nitesh Jha","Amul Fresh Cream has been processed to give smooth, consistency and makes mouth watering preparations",189,40.04,48.30,null,null);
				
						
				//add in list
				List<Product> products= new ArrayList<>();
				products.add(product1);
				products.add(product2);
				products.add(product3);
				products.add(product4);
		 
		 return products;
		

	}
	
		private List<ProductLine> createProductLines() {
		
		//Create Object
				ProductLine	productLine1 = new ProductLine(1L,"Amul offers a plethora of product lines that "
						+ "are closely related but still different .Its products include milk, flavored milk, chocolate","<ol>"
					    + "<li>Amul offers a plethora of product lines that are closely related but still different.<li>"
					    + "<li>Its products include milk, flavored milk, chocolate, butter, curd, yogurt, ghee, etc.<li>"
					    + "<ol>","D:\\Image of Project ANUD.jpg",null);
				
				ProductLine productLine2 = new ProductLine(2L,"Nestlé is the provider of the best food for whatever time of day "
				 		+ "and for whatever time of your life."+ "Its products include Baby Foods ,Milk ,Kit Kat ,"
				 		+ "Maggi Noodles ,Ice Cream  etc.." ,
				 		  "<ol>"
				 		+ "<li>Nestlé is the provider of the best food for whatever time of day.<li>"
				 		+ "<li>and for whatever time of your life.\"+ \"Its products include Baby Foods ,Milk ,Kit Kat<li>"
				 		+ "<li>Maggi Noodles ,Ice Cream  etc.<li>"
				 		+ "<ol>","D:\\Image of Project ANUD.jpg",null);
				 
				 ProductLine productLine3 = new ProductLine(3L,"Nivea is a skin & body care brand owned by a German company Beiersdorf."
						 +"Its products include Nivea Face Care, Nivea Deo ,Nivea Body ,Nivea Sun ,Nivea Men etc...",
						   "<ol>"
						 + "<li>Nivea is a skin & body care brand owned by a German company Beiersdorf.<li>"
						 + "<li>Its products include Nivea Face Care, Nivea Deo ,Nivea Body ,Nivea Sun ,Nivea Men etc....<li>"
						 + "<ol>","D:\\Image of Project ANUD.jpg",null);
				
				 
				 //add in list
				 List<ProductLine> productLinelist = new ArrayList<>();
					
				 productLinelist.add(productLine1);
				 productLinelist.add(productLine2);
				 productLinelist.add(productLine3);
				 
		return  productLinelist;
		
	}
		
			
		public List<Order> createOrder(){
			
		
			//Create Object
			Order order1 = new Order(new Date(2022, 11, 10),new Date(2022, 11, 22),new Date(2022, 11, 15),true,"Out for Delivery",null,null); 
			Order order2 = new Order(new Date(2022, 11, 15), new Date(2022, 11, 22),new Date(2022, 11, 18) ,true,"Return Order",null,null); 
			Order order3 = new Order(new Date(2022, 11, 20), new Date(2022, 11, 27), new Date(2022, 11, 25), true, "Received",null, null);
			Order order4 = new Order(new Date(2022, 11, 28), new Date(2022, 12, 10), new Date(2022, 11, 30), true, "Cancelled",null, null);
			
			List<Order> orderlist = new ArrayList<>();
			
			//add in list
			orderlist .add(order1);
			orderlist .add(order2);
			orderlist .add(order3);
			orderlist .add(order4);

			return orderlist;
		
			}
		
		public List<OrderDetail> createOrderDetail(){
			
			
			//Create object
			OrderDetail ordetail1 = new OrderDetail(2,550.70,1,null); 
			OrderDetail ordetail2 = new OrderDetail(2,526.34,2,null); 
			OrderDetail ordetail3 = new OrderDetail(2,526.34,3,null); 
			
			List<OrderDetail> orderDetaillist = new ArrayList<>();

			//add in list
		    orderDetaillist.add(ordetail1);
			orderDetaillist.add(ordetail2);
			orderDetaillist.add(ordetail3);
		
			
			return  orderDetaillist;

			}
		
		public List<Customer> createCustomer(){
			
			//Customer Object
			
			Customer customer1 = new Customer(1L,"Aryan Raj","Raj","Aryan", "7004871840","Hinoo, Ranchi", "Hinoo ,Ranchi",
		 			 "Ranchi","Jharkhand", 834002,"India", 15L, 50L, null, null,null);	 
			Customer customer2 = new Customer(2L,"Nisanth Malhotra","Malhotra","Nisanth","9800994509","Ranchi,Jharkhand","Doranda,Ranchi","Ranchi"
					 ,"Jharkhand", 834002,"India",12L,10L,null,null,null);
			Customer customer3 = new Customer(3L,"Anamika Kumari","Anamika","Kumari","8989899357","Ranchi,Jharkhand","Namkum,Ranchi","Ranchi"
				 			 ,"Jharkhand", 834010,"India",12L,10L,null,null,null);
		
			//add in list
			List<Customer> customerList = new ArrayList<>();
			 customerList.add(customer1);
			 customerList.add(customer2);
			 customerList.add(customer3);
		
			return  customerList;
			}
		
		
		
		public List<Payment>  createPayment(){
	
			//Create object
			Payment pay1 = new Payment(1L,new Date(2022, 11, 10) ,550.70,null); 
			Payment pay2 = new Payment(2L,new Date(2022, 11, 15) ,526.34,null); 
			Payment pay3 = new Payment(3L,new Date(2022, 11, 25) ,1200.34,null); 
		
			
			List<Payment> paymentlist = new ArrayList<>();
			//add in list
			paymentlist.add(pay1);
			paymentlist.add(pay2);
			paymentlist.add(pay3);
		
			
			return paymentlist;
		
			}
		
		
		public List<Employee> createEmployee(){
			//Employee Object
			Employee employee1 = new Employee(1L,"kerketta", "Priya", "Full-time", "priyakk@gmail.com", 
					"infotech-0020", "S.rao", "Full-stack dev", null, null,null);
			
			Employee employee2 = new Employee(2L,"jha","Ranjan","Full-time","ranjan2056@gmail.com",
					"Amazon Development Centre","M.singh","Cloud",null,null,null);

			Employee employee3 = new Employee(3L,"Das","Diya","Full-time","dasdiya986@gmail.com",
				  			"Amazon Development Centre","M.singh","web-dev",null,null,null);
		
			
			
			List<Employee> employeelist = new ArrayList<>();
			
			//add in list
			employeelist.add(employee1);
			employeelist.add(employee2);
			employeelist.add(employee3);
		
		
			return employeelist;
		
		}
		
		public List<Office> createOffice(){
			
			//Create object
			Office office1 = new Office(1L,"Patna","9862005135","Baliey Road","krish market","Patna","India",800001,"Patna",null);
			Office office2 = new Office(2L,"Bengalore","9876543211","Ferns City Road","Mahadevapura","Bengalore","India",560048,"Hyderabad",null);
			Office office3 = new Office(3l,"Ranchi", "9992344910", "Kanke Road Ranchi","Hinoo Doranda Ranchi","Jharkhand", "India", 834012, "Pvt Area", null); 	 
			
			List<Office> officelist = new ArrayList<>();
			
			//add in list	
			officelist.add(office1);
			officelist.add(office2);
			officelist.add(office3);
		
			return officelist;
		
		}
}
