package tyut.selab.desktop.moudle.book.domain.vo;

import tyut.selab.desktop.moudle.student.domain.vo.UserVo;

/**
 * 向ui展示的数据
 */
public class BookVo {
    private UserVo bookUserVo;
    private String BookName;
    private int bookStatus;
    private Double bookPrice;

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
}
