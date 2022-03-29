package com.torryharris.bookapp.Service;

import com.torryharris.bookapp.Model.Books;
import org.springframework.ui.Model;

import java.util.List;

public interface BookService{
    public List<Books> booksList();
    public String addBook(Books books, Model model);
    public String modifyBook(Books books, Model model);
    public String deleteBook(Books books, Model model);
    public String adminTableDetails(Model model);
    public List<Books> findAllByAuthorIsStartingWith(String author);
    public List<Books> findAllByBookNameIsStartingWith(String bookName);
    public List<Books> findAllBySectionIsStartingWith(String section);
    public Books findByBookCode(int bookCode);
    }
