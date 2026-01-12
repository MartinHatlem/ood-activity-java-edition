package no.loopacademy;
import no.loopacademy.Data.Book;
import no.loopacademy.Data.Member;

import java.util.*;

public class LibraryManager {

    private final List<Book> books = new ArrayList<>();
    private final List<Member> members = new ArrayList<>();
    private final BookBorrowingService bookBorrowingService = new BookBorrowingService();

    public void addBook(Book book) { books.add(book); }

    public void removeBook(Book book) {
        if (bookBorrowingService.isBookBorrowed(book)) {
            throw new IllegalStateException("Cannot remove the book " + book.getTitle() + " since it is currently borrowed by a member.");
        }
        books.removeIf(b -> b.equals(book));
    }

    public Book findBook(String title) {
        for (Book b : books) {
            if (Objects.equals(b.getTitle(), title)) return b;
        }
        return null;
    }

    public void registerMember(Member member) { members.add(member); }

    public void removeMember(Member member) {
        members.removeIf(m -> Objects.equals(m.getMemberId(), member.getMemberId()));
    }

    public Member findMember(String memberId) {
        for (Member m : members) {
            if (Objects.equals(m.getMemberId(), memberId)) return m;
        }
        return null;
    }
}
