package no.loopacademy;

import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import no.loopacademy.Data.Book;

public class BookBorrowingService {
    Map<Member, List<Book>> borrowedBooks = Map.of();

    public boolean isBookBorrowed(Book book) {
        for (Member member : borrowedBooks.keySet()) {
            for (Book borrowedBook : borrowedBooks.get(member)) {
                if (borrowedBook.equals(book)) {
                    return true;
                }
            }
        }
        return false;
    }

    
    public void borrowBook(Member member, Book book) {
        borrowedBooks.put(member, borrowedBooks.getOrDefault(member, new ArrayList<>()));
    }

    // Returns false if member hasn't borrowed the book
    public boolean returnBook(Member member, Book book) {
        return borrowedBooks.remove(member, book);
    }

    public List<Book> getBorrowedBooks(Member member) {
        return borrowedBooks.getOrDefault(member, new ArrayList<>());
    }

}
