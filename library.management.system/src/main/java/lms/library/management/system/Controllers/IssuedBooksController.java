package lms.library.management.system.Controllers;

import org.springframework.transaction.annotation.Transactional;

//import jakarta.transaction.Transactional;
import lms.library.management.system.DataAccessLayer.Books;
import lms.library.management.system.DataAccessLayer.BooksRepository;
import lms.library.management.system.DataAccessLayer.IssuedBooks;
import lms.library.management.system.DataAccessLayer.IssuedBooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class IssuedBooksController {

    @Autowired
    BooksRepository booksRepository;
    @Autowired
    IssuedBooksRepository issuedBooksRepository;

    @Transactional
    @PatchMapping("/issueBook/{name}")
    public ResponseEntity<String> issueBook(@PathVariable String name) {
        try {
            booksRepository.updateIssuedId(true, name);
            List<Books> issuedBooks= booksRepository.findBookByIsIssued(true);
            for(Books b : issuedBooks) {
                int id= b.getBookId();
                System.out.println(id);
                IssuedBooks issuedBook= new IssuedBooks(b.getBookId());
                issuedBook.setBorrowDate(issuedBook.getBorrowDate());
                issuedBook.setReturnDate(issuedBook.getReturnDate());
                issuedBook.setBooks(b);
                issuedBooksRepository.save(issuedBook);
                System.out.println("Book: " + issuedBook.getIssuedBookId() + " Return Date: " +issuedBook.getReturnDate());
            }
            return ResponseEntity.ok("Issued successfully");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Cannot issue book, sorry");
        }
    }

//    @GetMapping("/issuedBooksList")
//    public List<IssuedBooks> listOfIssuedBooks(){
//
//    }

}
