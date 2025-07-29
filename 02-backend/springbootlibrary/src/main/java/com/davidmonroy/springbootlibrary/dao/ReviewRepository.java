package com.davidmonroy.springbootlibrary.dao;

import com.davidmonroy.springbootlibrary.entity.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestParam;

public interface ReviewRepository extends JpaRepository<Review, Long>
{
    //find all reviews for a specific book using the book_id
    Page<Review> findByBookId(@RequestParam("book_id") Long bookId,
                              Pageable pageable);

}
