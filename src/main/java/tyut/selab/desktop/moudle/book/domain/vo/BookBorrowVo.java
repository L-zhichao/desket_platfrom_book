package tyut.selab.desktop.moudle.book.domain.vo;

import tyut.selab.desktop.moudle.student.domain.vo.UserVo;

import java.util.Date;

public class BookBorrowVo {
    private UserVo bookUserVo;
    private String BookName;
    private int bookStatus;
    private Double bookPrice;
    private UserVo borrowBookUserVo;
    private Date borrowBookTime;
    private Date returnBookTime;

    public UserVo getBookUserVo() {
        return bookUserVo;
    }

    public void setBookUserVo(UserVo bookUserVo) {
        this.bookUserVo = bookUserVo;
    }

    public String getBookName() {
        return BookName;
    }

    public void setBookName(String bookName) {
        BookName = bookName;
    }

    public int getBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(int bookStatus) {
        this.bookStatus = bookStatus;
    }

    public Double getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(Double bookPrice) {
        this.bookPrice = bookPrice;
    }

    public UserVo getBorrowBookUserVo() {
        return borrowBookUserVo;
    }

    public void setBorrowBookUserVo(UserVo borrowBookUserVo) {
        this.borrowBookUserVo = borrowBookUserVo;
    }

    public Date getBorrowBookTime() {
        return borrowBookTime;
    }

    public void setBorrowBookTime(Date borrowBookTime) {
        this.borrowBookTime = borrowBookTime;
    }

    public Date getReturnBookTime() {
        return returnBookTime;
    }

    public void setReturnBookTime(Date returnBookTime) {
        this.returnBookTime = returnBookTime;
    }
}
