package com.davidmonroy.springbootlibrary.service;

import com.davidmonroy.springbootlibrary.dao.BookRepository;
import com.davidmonroy.springbootlibrary.dao.CheckoutRepository;
import com.davidmonroy.springbootlibrary.entity.Book;
import com.davidmonroy.springbootlibrary.entity.Checkout;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Optional;

@Service
@Transactional
public class BookService
{

    private BookRepository bookRepository;
    private CheckoutRepository checkoutRepository;

    //constructor dependency injection
    public BookService(BookRepository bookRepository, CheckoutRepository checkoutRepository)
    {
        this.bookRepository = bookRepository;
        this.checkoutRepository = checkoutRepository;
    }

    public Book checkoutBook(String userEmail, Long bookId) throws Exception
    {
        Optional<Book> optionalBook = bookRepository.findById(bookId);

        Checkout validateCheckout = checkoutRepository.findByUserEmailAndBookId(userEmail, bookId);
        if (!optionalBook.isPresent() || validateCheckout != null || optionalBook.get().getCopiesAvailable() <= 0)
        {
            throw new Exception("Book doesn't exist or already checked out by user");
        }

        Book book = optionalBook.get();

        book.setCopiesAvailable(book.getCopiesAvailable() - 1);
        bookRepository.save(book);

        //create a new checkout entity and save it
        Checkout checkout = new Checkout(
                userEmail,
                LocalDate.now().toString(),
                LocalDate.now().plusDays(7).toString(),
                book.getId()
        );

        checkoutRepository.save(checkout);

        return book;
    }

    public Boolean checkoutBookByUser(String userEmail, Long bookId) {
        Checkout validateCheckout = checkoutRepository.findByUserEmailAndBookId(userEmail, bookId);
        return validateCheckout != null;
    }

    public int currentLoansCount(String userEmail) {
        return checkoutRepository.findBooksByUserEmail(userEmail).size();
    }
}
