package com.devsuperior.Myfirstproject;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.devsuperior.Myfirstproject.entities.Category;
import com.devsuperior.Myfirstproject.entities.Product;
import com.devsuperior.Myfirstproject.repositories.CategoryRepository;
import com.devsuperior.Myfirstproject.repositories.ProductRepository;

@SpringBootApplication
public class MyfirstprojectApplication implements CommandLineRunner{
	
	@Autowired
	private CategoryRepository repository;
	
	@Autowired
	private ProductRepository prodRepository;

	public static void main(String[] args) {
		SpringApplication.run(MyfirstprojectApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Category cat1 = new Category(1L, "Electronics");
		Category cat2 = new Category(2L, "Books");

		Product p1 = new Product(1L, "TV", 2200.00, cat1);
		Product p2 = new Product(2L, "Domain Driven Design", 120.00, cat2);
		Product p3 = new Product(3L, "PS5", 2800.00, cat1);
		Product p4 = new Product(4L, "Docker", 100.00, cat2);

		cat1.getProducts().addAll(Arrays.asList(p1, p3));//addAll add varios elementos ao mesmo tempo
		cat2.getProducts().addAll(Arrays.asList(p2, p4));
		
		repository.save(cat1);
		repository.save(cat2);
		
		prodRepository.save(p1);
		prodRepository.save(p2);
		prodRepository.save(p3);
		prodRepository.save(p4);
		
	}

}
