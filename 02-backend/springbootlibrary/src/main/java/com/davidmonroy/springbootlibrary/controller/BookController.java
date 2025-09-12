package com.davidmonroy.springbootlibrary.controller;

import com.davidmonroy.springbootlibrary.entity.Book;
import com.davidmonroy.springbootlibrary.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/api/books")
public class BookController
{
    private BookService bookService;

    @Autowired
    public BookController(BookService bookService)
    {
        this.bookService = bookService;
    }

    @GetMapping("/secure/ischeckedout/byuser")
    public Boolean checkoutBookByUser(@AuthenticationPrincipal Jwt jwt,
                                      @RequestParam Long bookId) {
        String userEmail = "testuser@gmail.com"; //hardcoded for now
        return bookService.checkoutBookByUser(userEmail, bookId);
    }

    @PutMapping("/secure/checkout")
    public Book checkoutBook(@AuthenticationPrincipal Jwt jwt, @RequestParam Long bookId) throws Exception
    {
        String userEmail = "testuser@gmail.com"; //hardcoded for now
        return bookService.checkoutBook(userEmail, bookId);
    }
}
