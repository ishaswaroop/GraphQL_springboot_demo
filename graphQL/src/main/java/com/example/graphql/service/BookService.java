package com.example.graphql.service;

import java.util.List;

import com.example.graphql.entity.Book;
import com.example.graphql.pojo.BookInput;

public interface BookService {

	Book create(Book book);

	List<Book> getAll();

	Book get(int bookId);
	
	Book delete(int bookId);
	
	Book update(int id,BookInput book);
	
}