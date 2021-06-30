package com.testejavaspring.config;


import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.testejavaspring.entities.Category;
import com.testejavaspring.entities.Company;
import com.testejavaspring.entities.Order;
import com.testejavaspring.entities.Product;
import com.testejavaspring.entities.User;
import com.testejavaspring.entities.enums.OrderStatus;
import com.testejavaspring.repositories.CategoryRepository;
import com.testejavaspring.repositories.CompanyRepository;
import com.testejavaspring.repositories.OrderRepository;
import com.testejavaspring.repositories.ProductRepository;
import com.testejavaspring.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private CompanyRepository companyRepository;
	
	@Override
	public void run(String... args) throws Exception {
	

		
		Company co1 =new Company(null, "Fabrica 1");
		Company a1 = new Company(null, "Armazem 1");
		Company a2 = new Company(null, "Armazem 2");
		
		companyRepository.saveAll(Arrays.asList(co1, a1, a2));
		
		Product x = new Product(null, "Product X","Televisao", 9000.5, "");
		Product y = new Product(null, "Product Y", "Bicicleta", 2190.0, "");
		
		Category cat1 = new Category(null, "Electronics");
		Category cat2 = new Category(null, "Brinquedos");
	
		categoryRepository.saveAll(Arrays.asList(cat1, cat2));
		productRepository.saveAll(Arrays.asList(x, y));
		
		x.getCategories().add(cat1);
		y.getCategories().add(cat2);
		
		productRepository.saveAll(Arrays.asList(x, y));
				
		User u1 = new User(null,"Cliente A", "5000", "3");
		User u2 = new User(null,"Cliente B", "7000", "2");
		User u3 = new User(null,"Cliente C", "3000", "1");
	
		Order o1 = new Order(null,Instant.parse("2021-06-26T20:44:07Z"), OrderStatus.PAID, u2, "2000");
		Order o2 = new Order(null, Instant.parse("2021-06-26T20:44:10Z"), OrderStatus.WAITING_PAYMENT,u2, "3000");
		Order o3 = new Order(null, Instant.parse("2021-06-26T20:45:22Z"), OrderStatus.WAITING_PAYMENT, u1, "1500");
		Order o4 = new Order(null, Instant.parse("2021-06-26T20:44:07Z"), OrderStatus.PAID, u1,"1500");
		Order o5 = new Order(null, Instant.parse("2021-06-26T20:44:10Z"), OrderStatus.WAITING_PAYMENT,u3, "2000");
		Order o6 = new Order(null, Instant.parse("2021-06-26T20:45:22Z"), OrderStatus.WAITING_PAYMENT, u3, "2000");
		
		userRepository.saveAll(Arrays.asList(u1,u2,u3));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3, o4, o5, o6));
		
	
	}

}
