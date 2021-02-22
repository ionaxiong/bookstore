package com.example.Bookstore.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Bookstore.model.Book;
import com.example.Bookstore.model.BookRepository;
import com.example.Bookstore.model.CategoryRepository;

@RestController
public class BookStoreController {
	
	@Autowired
	private BookRepository repository;
	
	@Autowired
	private CategoryRepository crepository;

	//RESTful service to get all books
	@RequestMapping("/books")
	public Iterable<Book> getBooks() {
		return repository.findAll();
	}
	
	//RESTful service to get book by id
	@RequestMapping(value="/books/{id}")
	public @ResponseBody Optional<Book> findBookById(@PathVariable("id") Long bookId) {
		return repository.findById(bookId);
	}

//	@RequestMapping(value={"/","/booklist"})
//	public String studenetList(Model model) {
//		model.addAttribute("books", repository.findAll());
//		return "booklist";
//	}
//	
//	@RequestMapping(value="/add")
//	public String addBook(Model model) {
//		model.addAttribute("book", new Book());
//		model.addAttribute("categories", crepository.findAll());
//		return "addbook";
//	}
//	
//	@RequestMapping(value="/save", method=RequestMethod.POST)
//	public String save(Book book) {
//		repository.save(book);
//		return "redirect:booklist";
//	}
//	
//	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
//	public String deleteBook(@PathVariable("id")Long bookId, Model model) {
//		repository.deleteById(bookId);
//		return "redirect:../booklist";
//	}
//	
//	@RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
//	public String editBook(@PathVariable("id")Long bookId, Model model){
//		model.addAttribute("book", repository.findById(bookId));
//		model.addAttribute("categories", crepository.findAll());
//		return "editbook";
//	}

}
