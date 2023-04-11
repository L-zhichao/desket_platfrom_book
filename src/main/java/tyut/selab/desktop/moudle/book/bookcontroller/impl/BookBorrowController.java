package tyut.selab.desktop.moudle.book.bookcontroller.impl;

import tyut.selab.desktop.moudle.book.bookcontroller.IBookBorrowController;
import tyut.selab.desktop.moudle.book.bookservice.IBookBorrowService;
import tyut.selab.desktop.moudle.book.bookservice.impl.BookBorrowService;
import tyut.selab.desktop.moudle.book.domain.vo.BookBorrowVo;
import tyut.selab.desktop.moudle.book.domain.vo.BookVo;
import tyut.selab.desktop.moudle.student.domain.vo.UserVo;

import javax.xml.crypto.Data;
import java.util.List;

import java.sql.SQLException;

public class BookBorrowController implements IBookBorrowController {

    private IBookBorrowService bookBorrowService = new BookBorrowService();
    @Override
    public BookBorrowVo borrowBook(BookVo book) {
        BookBorrowVo bookBorrowVo = bookBorrowService.borrowBook(book);
    public BookVo borrowBook(BookVo book) {
        return null;
    }

    @Override
    public BookVo returnBook(BookVo book) {
        return null;

    }

    @Override
    public int updateBookReturnTime(Data returnTime, BookVo bookVo) {
        return 0;
    }

    @Override
    public List<UserVo> exceedReturnTimeList() {
        return null;
    }
}
