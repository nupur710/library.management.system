package lms.library.management.system.Controllers;

import lms.library.management.system.DataAccessLayer.Books;
import lms.library.management.system.DataAccessLayer.BooksRepository;
import lms.library.management.system.Requests.BooksReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BooksController {

    @Autowired
    BooksRepository booksRepository;

    @PostMapping(value = "/addBook")
    public void addBook(@RequestBody BooksReq booksReq) {
        Books books= new Books(booksReq.getBookName(), booksReq.getAuthorName());
        booksRepository.save(books);
    }

    @GetMapping("/booksList")
    public List<Books> booksInSystem() {
        return booksRepository.findAll();
    }

    @DeleteMapping("/deleteBook")
    public List<Books> deleteBook() {
        List<Books> booksWithNoName= booksRepository.findByBookNameIsNull();
        System.out.println(booksWithNoName);
        for(Books book : booksWithNoName) {
            booksRepository.delete(book);
        }
        return booksWithNoName;
    }

}
