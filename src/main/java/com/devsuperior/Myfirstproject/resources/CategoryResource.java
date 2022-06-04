package com.devsuperior.Myfirstproject.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.Myfirstproject.entities.Category;
import com.devsuperior.Myfirstproject.repositories.CategoryRepository;

@RestController//recurso rest
@RequestMapping(value = "/categories")//caminho q o recurso vai percorrer
public class CategoryResource {
	
	@Autowired
	private CategoryRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Category>> findAll(){//responseEntity encapsula uma resposta http
		List<Category> list = repository.findAll();
		return ResponseEntity.ok().body(list);		
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Category> findById(@PathVariable Long id){//Path é para reconhecer o ID passado
		Category cat = repository.findById(id);
		return ResponseEntity.ok().body(cat);
	}

}
