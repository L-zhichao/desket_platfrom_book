package tyut.selab.desktop.moudle.book.bookservice.impl;

import tyut.selab.desktop.moudle.book.bookdao.IBookBorrowDao;
import tyut.selab.desktop.moudle.book.bookdao.IBookMessageDao;
import tyut.selab.desktop.moudle.book.bookdao.impl.BookBorrowDao;
import tyut.selab.desktop.moudle.book.bookdao.impl.BookMessageDao;
import tyut.selab.desktop.moudle.book.bookservice.IBookBorrowService;
import tyut.selab.desktop.moudle.book.bookservice.IBookMessageService;
import tyut.selab.desktop.moudle.book.domain.Book;
import tyut.selab.desktop.moudle.book.domain.BookBorrow;
import tyut.selab.desktop.moudle.book.domain.vo.BookBorrowVo;
import tyut.selab.desktop.moudle.book.domain.vo.BookVo;
import tyut.selab.desktop.moudle.student.userdao.IUserDao;

import java.sql.SQLException;

public class BookBorrowService implements IBookBorrowService {

    private IBookBorrowDao bookBorrowDao = new BookBorrowDao();

    private IBookMessageDao bookMessageDao = new BookMessageDao();

    private IUserDao userDao;
    @Override
    public BookBorrowVo borrowBook(BookVo book) throws SQLException, NoSuchFieldException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        Book newBook = new Book();
        newBook.setUserStudentNumber(book.getBookUserVo().getStudentNumber());
        newBook.setBookName(book.getBookName());
        newBook.setBookPrice(book.getBookPrice());
        newBook.setBookStatus(book.getBookStatus());
        int flag = bookMessageDao.updateBookStatus(Book.LENDED, newBook);
        BookBorrow bookBorrow = new BookBorrow();
        bookBorrow.setBorrowBookTime();
        bookBorrowDao.insertBorrowBookMessage()
        Book bookAsBorrow = bookMessageDao.queryAsBook(book.getBookUserVo().getStudentNumber(), book.getBookName());
        BookBorrow bookBorrow = bookMessageDao.queryBorrowBookById(bookAsBorrow.getBookId());
          BookBorrowVo bookBorrowVo = new BookBorrowVo();
          userDao.queryUserByStudentNumber()
          bookBorrowVo
          return ;
    }

    @Override
    public BookVo returnBook(BookBorrowVo book) {
        return null;
    }
}
