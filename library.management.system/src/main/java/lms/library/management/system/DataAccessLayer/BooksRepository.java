package lms.library.management.system.DataAccessLayer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BooksRepository extends JpaRepository<Books, Integer> {

    @Query(value = "select * from books where book_name is null", nativeQuery = true)
    public List<Books> findByBookNameIsNull();

    @Query(value = "select * from books where book_name =:name", nativeQuery = true)
    public Books findByBookName(@Param("name") String name);

    @Query(value= "select * from books where is_issued =:isIssued", nativeQuery = true)
    public List<Books> findBookByIsIssued(@Param("isIssued") boolean isIssued);

    //@Query(value = "UPDATE Books SET is_issued = :isIssued WHERE book_name = :name")
    @Modifying
    @Query("UPDATE Books b SET b.isIssued = :isIssued WHERE b.bookName = :name")
    public void updateIssuedId(@Param("isIssued") boolean isIssued, @Param("name") String name);

}
