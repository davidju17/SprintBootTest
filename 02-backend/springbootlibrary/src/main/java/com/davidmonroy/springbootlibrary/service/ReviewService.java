package com.davidmonroy.springbootlibrary.service;

import com.davidmonroy.springbootlibrary.dao.BookRepository;
import com.davidmonroy.springbootlibrary.dao.ReviewRepository;
import com.davidmonroy.springbootlibrary.entity.Review;
import com.davidmonroy.springbootlibrary.requestmodels.ReviewRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Objects;

@Service
@Transactional
public class ReviewService
{
    private ReviewRepository reviewRepository;

    @Autowired
    public ReviewService(ReviewRepository reviewRepository)
    {
        this.reviewRepository = reviewRepository;
    }

    public void postReview(String userEmail, ReviewRequest reviewRequest) throws Exception
    {
        Review validateReview = reviewRepository.findByUserEmailAndBookId(userEmail, reviewRequest.getBookId());
        if (validateReview != null)
        {
            throw new Exception("User has already created");
        }

        Review review = new Review();
        review.setBookId(review.getBookId());
        review.setRating(review.getRating());
        review.setUserEmail(userEmail);

        if(reviewRequest.getReviewDescription().isPresent())
        {
            review.setReviewDescription(reviewRequest.getReviewDescription().map(
                    Objects::toString
            ).orElse(null));
        }
        review.setDate(Date.valueOf(LocalDate.now()));
        reviewRepository.save(review);
    }

    public Boolean userReviewListed(String userEmail, Long bookId) 
    {
        Review validateReview = reviewRepository.findByUserEmailAndBookId(userEmail, bookId);
        return validateReview != null;
    }
}
