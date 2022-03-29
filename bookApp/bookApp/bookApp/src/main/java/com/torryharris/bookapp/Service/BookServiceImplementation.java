package com.torryharris.bookapp.Service;

import com.torryharris.bookapp.Model.Books;
import com.torryharris.bookapp.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

@Service
public class BookServiceImplementation implements BookService {

    @Autowired
    BookRepository bookRepository;


    public List<Books> booksList(){
        return bookRepository.findAll();
    }

    public String addBook(Books books, Model model){
        bookRepository.save(books);
        List<Books>booksList= bookRepository.findAll();
        model.addAttribute("ListBooks",booksList);
        return "AdminTable";
    }

    public String modifyBook(Books books, Model model){
        if(bookRepository.existsById(books.getBookCode())) {
            bookRepository.save(books);
            List<Books>booksList= bookRepository.findAll();
            model.addAttribute("ListBooks",booksList);
            return "AdminTable";
        }
        return "AdminTable";
    }
    public String deleteBook(Books books, Model model){
        bookRepository.deleteById(books.getBookCode());
        List<Books>booksList= bookRepository.findAll();
        model.addAttribute("ListBooks",booksList);
        return "AdminTable";
    }

    public String adminTableDetails(Model model){
        List<Books>booksList= bookRepository.findAll();
        model.addAttribute("ListBooks",booksList);
        return "AdminTable.html";

    }

    public List<Books> findAllByAuthorIsStartingWith(String author){
        return bookRepository.findAllByAuthorIsStartingWith(author);
    }

    public List<Books> findAllByBookNameIsStartingWith(String bookName){
        return bookRepository.findAllByBookNameIsStartingWith(bookName);
    }

    public List<Books> findAllBySectionIsStartingWith(String section){
        return bookRepository.findAllBySectionIsStartingWith(section);
    }

    public Books findByBookCode(int bookCode) {
        return bookRepository.findById(bookCode).get();
    }
}
