package tyut.selab.desktop.moudle.book.bookservice;


import tyut.selab.desktop.moudle.book.domain.Book;
import tyut.selab.desktop.moudle.book.domain.vo.BookBorrowVo;
import tyut.selab.desktop.moudle.book.domain.vo.BookVo;

import java.sql.SQLException;
import java.util.Base64;

public interface IBookBorrowService {
    /**
     * 借书
     * @param book
     * @return 借书的信息
     */
    BookBorrowVo borrowBook(BookBorrowVo book) throws SQLException, NoSuchFieldException, ClassNotFoundException, InstantiationException, IllegalAccessException;

    /**
     * 还书
     * @param book
     * @return
     */
    BookVo returnBook(BookBorrowVo book) throws SQLException, NoSuchFieldException, ClassNotFoundException, InstantiationException, IllegalAccessException;
}
