import { useEffect, useState } from "react";
import BookModel from "../../models/BookModel";

export const BookCheckoutPage = () => {

    const [book, setBook] = useState<BookModel>();
    const [isLoading, setIsLoading] = useState(true);
    const [httpError, setHttpError] = useState(null);

    const bookId = (window.location.pathname).split('/')[2];

    return (
        <div>
            <h1>Book Checkout {bookId}</h1>
        </div>
    );
}