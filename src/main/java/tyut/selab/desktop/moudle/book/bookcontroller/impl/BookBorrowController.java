package tyut.selab.desktop.moudle.book.bookcontroller.impl;

import tyut.selab.desktop.moudle.book.bookcontroller.IBookBorrowController;
import tyut.selab.desktop.moudle.book.bookservice.IBookBorrowService;
import tyut.selab.desktop.moudle.book.bookservice.impl.BookBorrowService;
import tyut.selab.desktop.moudle.book.domain.vo.BookBorrowVo;
import tyut.selab.desktop.moudle.book.domain.vo.BookVo;

public class BookBorrowController implements IBookBorrowController {

    private IBookBorrowService bookBorrowService = new BookBorrowService();

    @Override
    public BookBorrowVo borrowBook(BookVo book) {
        BookBorrowVo bookBorrowVo = bookBorrowService.borrowBook(book);
        return null;
    }

    @Override
    public BookVo returnBook(BookBorrowVo book) {
        return null;
    }
}
