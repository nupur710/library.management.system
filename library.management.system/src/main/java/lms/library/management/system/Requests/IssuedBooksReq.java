package lms.library.management.system.Requests;

public class IssuedBooksReq {

    private int issuedBookId;
    private String borrowDate;
    private String returnDate;

    public int getIssuedBookId() {
        return issuedBookId;
    }

    public void setIssuedBookId(int issuedBookId) {
        this.issuedBookId = issuedBookId;
    }

    public String getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(String borrowDate) {
        this.borrowDate = borrowDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }
}
