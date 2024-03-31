package com.example.graphql.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.graphql.entity.Book;

public interface BookRep extends JpaRepository<Book, Integer> {
}