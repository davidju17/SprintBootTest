package com.davidmonroy.springbootlibrary.dao;

import com.davidmonroy.springbootlibrary.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long>
{

}
