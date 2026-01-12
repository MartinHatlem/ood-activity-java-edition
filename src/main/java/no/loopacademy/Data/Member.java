package no.loopacademy.Data;

import java.util.ArrayList;
import java.util.List;

public class Member {
    private String name;
    private String memberId;
    private List<Book> borrowedBooks = new ArrayList<>();

    public Member() { }

    public Member(String name, String memberId) {
        this.name = name;
        this.memberId = memberId;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getMemberId() { return memberId; }
    public void setMemberId(String memberId) { this.memberId = memberId; }

    public void update(Member updatedMember) {
        this.name = updatedMember.getName();
        this.memberId = updatedMember.getMemberId();
    }

    public void borrowBook(Book book) {
        borrowedBooks.add(book);
    }

    // Returns false if member hasn't borrowed the book
    public boolean returnBook(Book book) {
        return borrowedBooks.removeIf(b -> 
            b.getTitle().equals(book.getTitle()) && 
            b.getAuthor().equals(book.getAuthor())
        );
    }

    public List<Book> getBorrowedBooks() {
        return new ArrayList<>(borrowedBooks);
    }
}
