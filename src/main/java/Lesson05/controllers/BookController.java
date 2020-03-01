package Lesson05.controllers;

import Lesson05.entities.Book;
import Lesson05.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {

    private BookService bookService;

    @Autowired
    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping("/list")
    public String showBooksList(Model model){
        List<Book> allBooks = bookService.getAllBooksList();
        model.addAttribute("booksList", allBooks);
        return "books-list";
    }

    @RequestMapping(path="/add", method= RequestMethod.GET)
    public String showAddForm(Model model){
        Book book = new Book();
        book.setTitle("Unknown");
        book.setDescription("Unknown");
        book.setYear(0);
        model.addAttribute("book", book);
        return "add-book-form";
    }

    @RequestMapping(path="/add", method=RequestMethod.POST)
    public String showAddForm(Book book) {
        bookService.addBook(book);
        return "redirect:/books/list";
    }



}
