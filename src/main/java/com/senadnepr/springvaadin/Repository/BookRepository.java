package com.senadnepr.springvaadin.Repository;

import com.senadnepr.springvaadin.Entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long>{
}
