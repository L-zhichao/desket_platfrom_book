package tyut.selab.desktop.moudle.book.bookservice.impl;

import tyut.selab.desktop.moudle.book.bookdao.IBookBorrowDao;
import tyut.selab.desktop.moudle.book.bookdao.IBookMessageDao;
import tyut.selab.desktop.moudle.book.bookservice.IBookBorrowService;
import tyut.selab.desktop.moudle.book.bookservice.IBookMessageService;
import tyut.selab.desktop.moudle.book.domain.Book;
import tyut.selab.desktop.moudle.book.domain.BookBorrow;
import tyut.selab.desktop.moudle.book.domain.vo.BookBorrowVo;
import tyut.selab.desktop.moudle.book.domain.vo.BookVo;
import tyut.selab.desktop.moudle.student.userdao.IUserDao;

import javax.xml.crypto.Data;
import java.util.List;

import java.sql.SQLException;

public class BookBorrowService implements IBookBorrowService {

    private IBookBorrowDao bookBorrowDao = new BookBorrowDao();

    private IBookMessageDao bookMessageDao = new BookMessageDao();

    private IUserDao userDao;

    @Override
    public BookVo borrowBook(BookVo book) {
        return null;
    }

    @Override
    public BookBorrowVo borrowBook(BookBorrowVo book) throws SQLException, NoSuchFieldException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        Book newBook = new Book();
        newBook.setUserStudentNumber(book.getBookUserVo().getStudentNumber());
        newBook.setBookName(book.getBookName());
        newBook.setBookPrice(book.getBookPrice());
        newBook.setBookStatus(book.getBookStatus());
        int flag = bookMessageDao.updateBookStatus(Book.LENDED, newBook);
        Book willBorrowBook = bookMessageDao.queryAsBook(book.getBookUserVo().getStudentNumber(), book.getBookName());
        BookBorrow bookBorrow = new BookBorrow();
        bookBorrow.setBorrowBookTime(book.getBorrowBookTime());
        bookBorrow.setReturnBookTime(book.getReturnBookTime());
        bookBorrow.setBookId(willBorrowBook.getBookId());
        bookBorrow.setUserStudentNumber(willBorrowBook.getUserStudentNumber());
        bookBorrow.setBorrowUserStudentNumber(book.getBorrowBookUserVo().getStudentNumber());
        int flag1 = bookBorrowDao.insertBorrowBookMessage(bookBorrow);
        Book bookAsBorrow = bookMessageDao.queryAsBook(book.getBookUserVo().getStudentNumber(), book.getBookName());
        BookBorrow bookBorrow = bookMessageDao.queryBorrowBookById(bookAsBorrow.getBookId());
          BookBorrowVo bookBorrowVo = new BookBorrowVo();
          userDao.queryUserByStudentNumber()
          bookBorrowVo
          return ;
    public BookVo returnBook(BookVo book) {
        return null;
    }

    @Override
    public BookVo returnBook(BookBorrowVo book) throws SQLException, NoSuchFieldException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        Book newBook = bookMessageDao.queryAsBook(book.getBookUserVo().getStudentNumber(), book.getBookName());
        BookBorrow bookBorrow = new BookBorrow();
        bookBorrow.setBookId(newBook.getBookId());
        int flag = bookBorrowDao.deleteBorrowBook(bookBorrow);
        int flag1 = bookMessageDao.updateBookStatus(Book.LENDABLE, newBook);

        return ;
    public int updateBookReturnTime(Data returnTime, BookVo bookVo) {
        return 0;
    }

    @Override
    public List<BookVo> exceedReturnTimeList() {
        return null;
    }
}
