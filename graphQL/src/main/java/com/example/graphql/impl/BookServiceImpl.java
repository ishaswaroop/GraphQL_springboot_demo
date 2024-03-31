package com.example.graphql.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.graphql.entity.Book;
import com.example.graphql.pojo.BookInput;
import com.example.graphql.repository.BookRep;
import com.example.graphql.service.BookService;

@Service
public class BookServiceImpl implements BookService {

	private BookRep bookRep;

	@Autowired
	public BookServiceImpl(BookRep bookRep) {
		this.bookRep = bookRep;
	}

	@Override
	public Book create(Book book) {
		return this.bookRep.save(book);
	}

	@Override
	public List<Book> getAll() {
		return this.bookRep.findAll();
	}

	@Override
	public Book get(int bookId) {
		return this.bookRep.findById(bookId)
				.orElseThrow(() -> new RuntimeException("Book you are looking for not found on server !!"));
	}

	@Override
	public Book delete(int bookId) {
		Optional<Book> book = bookRep.findById(bookId);
		if (book.isPresent()) {
			bookRep.deleteById(bookId);
			return book.get();
		} else {
			throw new RuntimeException("Book you are looking for not found on server !");
		}
	}

	@Override
	public Book update(int id, BookInput book) {

		Optional<Book> updateBook = bookRep.findById(id);
		if (updateBook.isPresent()) {
			Book b = new Book();
			b.setId(id);
			b.setAuthor(book.getAuthor());
			b.setDesc(book.getDesc());
			b.setPages(book.getPages());
			b.setPrice(book.getPrice());
			b.setAuthor(book.getTitle());
			return bookRep.save(b);
		}
		return null;
	}
}