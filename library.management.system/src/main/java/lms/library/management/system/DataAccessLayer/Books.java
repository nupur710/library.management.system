package lms.library.management.system.DataAccessLayer;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Books {

    public Books(){};

    public Books(String bookName, String authorName) {
        this.bookName= bookName;
        this.authorName= authorName;
    }

    public String toString() {
        return "id: " + this.bookId + "\n name: " + this.bookName + "\n author's name: " + this.authorName;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int bookId;
    private String bookName;
    private String authorName;
    @OneToMany(mappedBy = "books", cascade = CascadeType.ALL)
    private Set<IssuedBooks> issuedBooksSet;

    private boolean isIssued;

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public Set<IssuedBooks> getIssuedBooksSet() {
        return issuedBooksSet;
    }

    public void setIssuedBooksSet(Set<IssuedBooks> issuedBooksSet) {
        this.issuedBooksSet = issuedBooksSet;
    }

    public boolean isIssued() {
        return isIssued;
    }

    public void setIssued(boolean issued) {
        isIssued = issued;
    }
}
