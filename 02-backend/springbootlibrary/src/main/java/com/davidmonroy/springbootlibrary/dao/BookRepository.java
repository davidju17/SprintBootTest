package com.davidmonroy.springbootlibrary.dao;

import com.davidmonroy.springbootlibrary.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long>
{
    //http://localhost:8080/api/books/search is the endpoint for new search functionality in this repository

    Page<Book> findByTitleContaining(@RequestParam("title") String title, Pageable pageable);
}
