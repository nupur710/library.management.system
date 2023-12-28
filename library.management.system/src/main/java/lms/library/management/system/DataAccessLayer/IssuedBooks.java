package lms.library.management.system.DataAccessLayer;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Entity
public class IssuedBooks {

    public IssuedBooks() {}

    public IssuedBooks(int issuedBookId, Books books) {
        this.issuedBookId= issuedBookId;
        this.books= books;
    }

    public IssuedBooks(int issuedBookId) {
        this.issuedBookId= issuedBookId;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int issuedBookId;

    @ManyToOne
    @JoinColumn(name= "book_id")
    private Books books;
    private LocalDate borrowDate;
    private LocalDate returnDate;

    public int getIssuedBookId() {
        return issuedBookId;
    }

    public void setIssuedBookId(int issuedBookId) {
        this.issuedBookId = issuedBookId;
    }

    public Books getBooks() {
        return books;
    }

    public void setBooks(Books books) {
        this.books = books;
    }

    public LocalDate getBorrowDate() {
        LocalDate today= LocalDate.now();
        DateTimeFormatter formatter= DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedToday= today.format(formatter);
        return today;
    }


    public LocalDate getReturnDate() {
        LocalDate today = LocalDate.now();
        LocalDate futureDate = today.plusWeeks(4);
        DateTimeFormatter formatter= DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedReturnDate= futureDate.format(formatter);
        return futureDate;
    }

    public void setBorrowDate(LocalDate borrowDate) {
        this.borrowDate = borrowDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }
}
