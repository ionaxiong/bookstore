package com.example.Bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.Bookstore.model.Book;
import com.example.Bookstore.model.BookRepository;
import com.example.Bookstore.model.Category;
import com.example.Bookstore.model.CategoryRepository;
import com.example.Bookstore.model.User;
import com.example.Bookstore.model.UserRepository;

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner bookDemo(BookRepository repository, CategoryRepository crepository, UserRepository urepository) {
		return(args) -> {
			log.info("save a couple of books");
			crepository.save(new Category("Classics"));
			crepository.save(new Category("Fantasy"));
			crepository.save(new Category("Literary Fiction"));
			
			repository.save(new Book("To Kill a Mockingbird", "Harper Lee", "1960", "123456789", "100", crepository.findByName("Classics").get(0)));
			repository.save(new Book("Harry Potter and the Philosopher’s Stone", "J.K. Rowling", "2000", "987654321", "110", crepository.findByName("Fantasy").get(0)));
			repository.save(new Book("Pride and Prejudice", "Jane Austen", "1813", "5413248987", "120", crepository.findByName("Literary Fiction").get(0)));
			
			BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
			String userPassword = bcrypt.encode("user");
			String adminPassword = bcrypt.encode("admin");
			urepository.deleteAll();
			User user1 = new User("user", userPassword, "user@user.com", "USER");
			User user2 = new User("admin", adminPassword, "admin@admin.com", "ADMIN");
			urepository.save(user1);
			urepository.save(user2);
			
			log.info("fetch all books");
			for (Book book: repository.findAll()) {
				log.info(book.toString());
			}
		};
}

}
