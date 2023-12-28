package lms.library.management.system.DataAccessLayer;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Users {

    public Users() {}

    public Users(String userName, String phone) {
        this.userName = userName;
        this.phone = phone;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;
    private String userName;
    private String phone;
 //   private IssuedBooks issuedBooks;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

//    public IssuedBooks getIssuedBooks() {
//        return issuedBooks;
//    }

//    public void setIssuedBooks(IssuedBooks issuedBooks) {
//        this.issuedBooks = issuedBooks;
//    }
}
