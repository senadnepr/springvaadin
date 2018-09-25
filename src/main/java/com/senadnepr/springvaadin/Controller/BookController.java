package com.senadnepr.springvaadin.Controller;

import com.senadnepr.springvaadin.Entity.Book;
import com.senadnepr.springvaadin.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Controller

public class BookController {

    @Autowired
    private BookService bookService;

    public List<Book> getAllBook(String filter) {
        List<Book> books = bookService.findAll();

        ArrayList<Book> arrayList = new ArrayList<>();

        for (Book book : books) {

                boolean passesFilter = (filter == null || filter.isEmpty())
                        || book.toString().toLowerCase().contains(filter.toLowerCase());
                if (passesFilter) {
                    try {
                        arrayList.add(book.clone());
                    } catch (CloneNotSupportedException e) {
                        e.printStackTrace();
                    }
                }

        }
        return arrayList;
    }

    public void delete(Book book) {
        bookService.delete(book);
    }

    public void save(Book book) {
        bookService.save(book);
    }

//    public boolean searchBook(Book book){
//        if(bookService.findById(book.getId()) != null) return true;
//        else return false;
//    }
}