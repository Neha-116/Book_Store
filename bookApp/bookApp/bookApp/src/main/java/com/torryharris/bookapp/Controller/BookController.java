package com.torryharris.bookapp.Controller;

import com.torryharris.bookapp.Constants.PropertyConstants;
import com.torryharris.bookapp.Model.Books;
import com.torryharris.bookapp.Service.BookService;
import com.torryharris.bookapp.Service.BookServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class BookController {

    @Autowired
    BookService bookService;

    /**
     * Home page
     */
    @GetMapping(PropertyConstants.HOME)
    public String home(Model model){
        return "outlook";
    }

    /**
     * Gets all the values from repository
     * Returns values and displays in UserBookTable
     */
    @GetMapping(PropertyConstants.USERBOOKSTABLE)
    public String UserBooksTable(Model model) {
        List<Books> booksList = bookService.booksList();
        model.addAttribute("ListBooks", booksList);
        return "UserBooksTable";
    }

    /**
     * Returns AddBooks table for adding book details to save in repository.
     */
    @GetMapping(PropertyConstants.ADDBOOKSPAGE)
    public String addBook() {
        return "AddBooks";
    }

    /**
     * Gets values from AddBooks table and stores it in repository.
     * Returns Admin table table for further operations.
     */
    @PostMapping(PropertyConstants.ADDBOOKSVALUES)
    public String addBooksValues(Books books, Model model) {
        return bookService.addBook(books,model);
    }

    /**
     * Gets values from DB and displays for user for modifying.
     * Returns EditAdminTable for modifying values.
     */
    @GetMapping(PropertyConstants.MODIFYBOOKPAGE)
    public String modifyBook(@PathVariable("bookCode") int bookCode, Books books, Model model) {
        books= bookService.findByBookCode(bookCode);
        model.addAttribute("modifyBook",books);
        return "EditAdminTable";
    }

    /**
     * Gets values from EditAdminTable and modify it in repository.
     * Returns Admin table for further operations.
     */
    @GetMapping(PropertyConstants.MODIFYBOOKVALUES)
    public String modify(Books books,Model model){
        return bookService.modifyBook(books,model);
    }

    /**
     * Gets book code value from AdminTable and delete the value in repository.
     * Returns Admin table for further operations.
     */
    @GetMapping(PropertyConstants.DELETEBOOK)
    public String deleteBook(@PathVariable("bookCode") int bookCode, Books books, Model model) {
        return bookService.deleteBook(books,model);
    }

    /**
     * Admin Table
     */
    @RequestMapping(PropertyConstants.ADMINTABLEDETAILS)
    public String showAdminTable(Model model){
        List<Books>booksList= bookService.booksList();
        model.addAttribute("ListBooks",booksList);
        return "AdminTable";
    }

    /**
     * Gets values from DB and displays for user.
     * Returns UserBooksTable for further operations.
     */
    @GetMapping(PropertyConstants.RELOADUSERBOOKTABLE)
    public String ReloadUserBooksTable(Model model){
        List<Books>booksList= bookService.booksList();
        System.out.println(model.getAttribute("total"));
        model.addAttribute("total",model.getAttribute("total"));
        model.addAttribute("ListBooks",booksList);
        return "UserBooksTable";
    }

    /**
     * Gets values for filtering and displays for admin.
     * Returns Admin Table for further operations.
     */
    @GetMapping(PropertyConstants.FILTERADMIN)
    public String filterAdmin(HttpServletRequest request, Model model ){
        switch (request.getParameter("filter")) {
                case "author":
                    List<Books>booksListByAuthor= bookService.findAllByAuthorIsStartingWith(request.getParameter("word"));
                    model.addAttribute("ListBooks",booksListByAuthor);
                    return "AdminTable";
                case "bookName":
                    List<Books>booksListByBookName= bookService.findAllByBookNameIsStartingWith(request.getParameter("word"));
                    model.addAttribute("ListBooks",booksListByBookName);
                    return "AdminTable";
                case "section":
                    List<Books>booksListBySection= bookService.findAllBySectionIsStartingWith(request.getParameter("word"));
                    model.addAttribute("ListBooks",booksListBySection);
                    return "AdminTable";
            }
        return "AdminTable";
    }

    /**
     * Gets values for filtering and displays for user.
     * Returns UserBooks Table for further operations.
     */
    @GetMapping(PropertyConstants.FILTERUSER)
    public String filterUser(HttpServletRequest request, Model model ){
        switch (request.getParameter("filter")) {
            case "author":
                List<Books>booksListByAuthor= bookService.findAllByAuthorIsStartingWith(request.getParameter("word"));
                model.addAttribute("ListBooks",booksListByAuthor);
                return "UserBooksTable";
            case "bookName":
                List<Books>booksListByBookName= bookService.findAllByBookNameIsStartingWith(request.getParameter("word"));
                model.addAttribute("ListBooks",booksListByBookName);
                return "UserBooksTable";
            case "section":
                List<Books>booksListBySection= bookService.findAllBySectionIsStartingWith(request.getParameter("word"));
                model.addAttribute("ListBooks",booksListBySection);
                return "UserBooksTable";
        }
        return "UserBooksTable";
    }

}