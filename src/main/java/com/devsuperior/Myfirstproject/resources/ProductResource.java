package com.devsuperior.Myfirstproject.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.Myfirstproject.entities.Product;
import com.devsuperior.Myfirstproject.repositories.ProductRepository;

@RestController//recurso rest
@RequestMapping(value = "/products")//caminho q o recurso vai percorrer
public class ProductResource {
	
	@Autowired
	private ProductRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Product>> findAll(){//responseEntity encapsula uma resposta http
		List<Product> list = repository.findAll();
		return ResponseEntity.ok().body(list);		
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Product> findById(@PathVariable Long id){//Path é para reconhecer o ID passado
		Product cat = repository.findById(id);
		return ResponseEntity.ok().body(cat);
	}

}
