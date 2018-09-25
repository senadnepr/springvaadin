package com.senadnepr.springvaadin.Service;

import com.senadnepr.springvaadin.Entity.Book;

import java.util.List;

public interface BookService {

    List<Book> findAll();
    void delete(Book book);
    void save(Book book);
    Book findById(Long id);

}
