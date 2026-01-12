package no.loopacademy;
import no.loopacademy.Data.Book;
import no.loopacademy.Data.Member;

import java.util.*;

public class LibraryManager {

    public final List<Book> books = new ArrayList<>();
    public final List<Member> members = new ArrayList<>();

    public void addBook(Book book) { books.add(book); }

    public void removeBook(Book book) {
        if (isBookBorrowed(book)) {
            throw new IllegalStateException("Cannot remove the book " + book.getTitle() + " since it is currently borrowed by a member.");
        }
        books.removeIf(b -> Objects.equals(b.getTitle(), book.getTitle())
                && Objects.equals(b.getAuthor(), book.getAuthor()));
    }

    private boolean isBookBorrowed(Book book) {
        for (Member member : members) {
            for (Book borrowedBook : member.getBorrowedBooks()) {
                if (Objects.equals(borrowedBook.getTitle(), book.getTitle()) &&
                    Objects.equals(borrowedBook.getAuthor(), book.getAuthor())) {
                    return true;
                }
            }
        }
        return false;
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
