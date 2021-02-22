package com.example.Bookstore.model;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface BookRepository extends CrudRepository<Book, Long> {
	
	List<Book> findById(@Param("id") String id);
	
	List<Book> findByIsbn (@Param("isbn") String isbn);
	
	List<Book> findByAuthor (@Param("author") String author);
}
