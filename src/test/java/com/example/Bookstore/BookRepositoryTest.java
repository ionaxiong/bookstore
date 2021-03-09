package com.example.Bookstore;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.example.Bookstore.model.Book;
import com.example.Bookstore.model.BookRepository;
import com.example.Bookstore.model.Category;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BookRepositoryTest {

	@Autowired
	private BookRepository repository;
	
	//Test search
	@Test
	public void findByTitleShouldReturnBook() {
		List<Book> books = repository.findByTitle("To Kill a Mockingbird");
		assertThat(books).hasSize(1);
		assertThat(books.get(0).getIsbn()).isEqualTo("123456789");
	}
	
	//Test delete
	@Test
	public void DeleteAllFromRepository() {
		repository.deleteAll();
		assertThat(repository.count()).isEqualTo(0);
	}
	
	//Test create
	@Test
	public void createNewBook() {
		Book book = new Book("Animal Farm", "George Orwell", "1945", "1010101010", "100", new Category("Fantasy"));
		repository.save(book);
		assertThat(book.getId()).isNotNull();
	}
}
