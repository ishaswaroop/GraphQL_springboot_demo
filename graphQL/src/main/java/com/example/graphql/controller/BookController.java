package com.example.graphql.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.example.graphql.entity.Book;
import com.example.graphql.pojo.BookInput;
import com.example.graphql.service.BookService;

@Controller
public class BookController {

	@Autowired
	private BookService bookService;

	// create

	@MutationMapping("createBook")
	public Book create(@Argument BookInput book) {
		Book b = new Book();
		b.setTitle(book.getTitle());
		b.setDesc(book.getDesc());
		b.setPrice(book.getPrice());
		b.setAuthor(book.getAuthor());
		b.setPages(book.getPages());
		return this.bookService.create(b);
	}

	// get all

	@QueryMapping("allBooks")
	public List<Book> getAll() {
		return this.bookService.getAll();
	}

	// get single book
	
	@QueryMapping("getBook")
	public Book get(@Argument int bookId) {
		return this.bookService.get(bookId);
	}
	
	//delete a single book

	@MutationMapping("deleteBook")
	public Book delete(@Argument int bookId) {
		return this.bookService.delete(bookId);
	}
	
	//update a single book 

	@MutationMapping("updateBook")
	public Book update(@Argument int id, @Argument BookInput book) {
		return this.bookService.update(id, book);

	}
}
