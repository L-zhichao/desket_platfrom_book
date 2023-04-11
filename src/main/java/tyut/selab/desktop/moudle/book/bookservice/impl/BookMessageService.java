package tyut.selab.desktop.moudle.book.bookservice.impl;

import tyut.selab.desktop.moudle.book.bookdao.IBookBorrowDao;
import tyut.selab.desktop.moudle.book.bookdao.IBookMessageDao;
import tyut.selab.desktop.moudle.book.bookdao.impl.BookBorrowDao;
import tyut.selab.desktop.moudle.book.bookdao.impl.BookMessageDao;
import tyut.selab.desktop.moudle.book.bookservice.IBookMessageService;
import tyut.selab.desktop.moudle.book.domain.Book;
import tyut.selab.desktop.moudle.book.domain.BookBorrow;
import tyut.selab.desktop.moudle.book.domain.vo.BookBorrowVo;
import tyut.selab.desktop.moudle.book.domain.vo.BookVo;
import tyut.selab.desktop.moudle.student.domain.User;
import tyut.selab.desktop.moudle.student.domain.vo.UserVo;
import tyut.selab.desktop.moudle.student.usercontroller.IUserController;
import tyut.selab.desktop.moudle.student.usercontroller.impl.UserController;
import tyut.selab.desktop.moudle.student.userdao.IUserDao;
import tyut.selab.desktop.moudle.student.userdao.impl.UserDao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookMessageService implements IBookMessageService {
    private IBookMessageDao bookMessageDao = new BookMessageDao();
   private IBookBorrowDao bookBorrowDao = new BookBorrowDao();

    private IUserDao userDao = new UserDao();
    @Override
    public List<BookBorrowVo> queryBorrowBookLog() throws SQLException, NoSuchFieldException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        List<BookBorrow> bookBorrows = bookMessageDao.queryBorrowBookLog();
        List<BookBorrowVo> bookBorrowVos = new ArrayList<>();
        for (int i = 0; i < bookBorrows.size(); i++) {
            BookBorrowVo bookBorrowVo = new BookBorrowVo();
            Integer borrowUserStudentNumber = bookBorrows.get(i).getBorrowUserStudentNumber();
            User userBorrow = userDao.queryUserByStudentNumber(borrowUserStudentNumber);
            UserVo userVoBorrow = userChangeUserVo(userBorrow);
            bookBorrowVo.setBorrowBookUserVo(userVoBorrow);
            Integer userStudentNumber = bookBorrows.get(i).getUserStudentNumber();
            User userUser = userDao.queryUserByStudentNumber(userStudentNumber);
            UserVo userVoUser = userChangeUserVo(userUser);
            bookBorrowVo.setBookUserVo(userVoUser);
            bookBorrowVo.setBorrowBookTime(bookBorrows.get(i).getBorrowBookTime());
            bookBorrowVo.setReturnBookTime(bookBorrows.get(i).getReturnBookTime());
            Book book = bookMessageDao.queryBookById(bookBorrows.get(i).getBookId());
            bookBorrowVo.setBookName(book.getBookName());
            bookBorrowVo.setBookPrice(book.getBookPrice());
            bookBorrowVo.setBookStatus(book.getBookStatus());
            bookBorrowVos.add(bookBorrowVo);
        }
        return bookBorrowVos;
    }


    public List<BookBorrowVo> queryBorrowBookLog(String bookName) throws SQLException, NoSuchFieldException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        List<BookBorrow> bookBorrows = bookMessageDao.queryBorrowBookByName(bookName);
        List<BookBorrowVo> bookBorrowVos = new ArrayList<>();
        for (int i = 0; i < bookBorrows.size(); i++) {
             BookMessageService bookMessageService = new BookMessageService();
            BookBorrowVo bookBorrowVo = bookMessageService.bookBorrowChangeBookBorrowVo(bookBorrows.get(i));
            bookBorrowVos.add(bookBorrowVo);
        }
        return bookBorrowVos;

    @Override
    public List<BookBorrowVo> queryBorrowBookLog(Integer userStudentNumber) throws SQLException, NoSuchFieldException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        List<BookBorrowVo> bookBorrowVos = new ArrayList<>();
        BookMessageService bookMessageService = new BookMessageService();
        List<BookBorrow> bookBorrows = bookMessageDao.queryBorrowBookByUserid(userStudentNumber);
        for (int i = 0; i < bookBorrows.size(); i++) {
            BookBorrowVo bookBorrowVo = bookMessageService.bookBorrowChangeBookBorrowVo(bookBorrows.get(i));
            bookBorrowVos.add(bookBorrowVo);
        }
        return bookBorrowVos;
    }

        @Override
        public List<BookVo> queryAllBook() throws SQLException, NoSuchFieldException, ClassNotFoundException, InstantiationException, IllegalAccessException {
            List<Book> books = bookMessageDao.queryAllBook();
            List<BookVo> bookVos = new ArrayList<>();
            for (int i = 0; i < books.size(); i++) {
                Integer userStudentNumber = books.get(i).getUserStudentNumber();
                User user = userDao.queryUserByStudentNumber(userStudentNumber);
                UserVo userVo = userChangeUserVo(user);
                BookVo bookVo = new BookVo();
                bookVo.setBookUserVo(userVo);
                bookVo.setBookName(books.get(i).getBookName());
                bookVo.setBookStatus(books.get(i).getBookStatus());
                bookVo.setBookPrice(books.get(i).getBookPrice());
                bookVos.add(bookVo);
            }
            return bookVos;
        }

    @Override
        public List<BookVo> queryBookByBookName(String bookName) throws SQLException, NoSuchFieldException, ClassNotFoundException, InstantiationException, IllegalAccessException {
            List<Book> books = bookMessageDao.queryBookByBookName(bookName);
            List<BookVo> bookVos = new ArrayList<>();
            for (int i = 0; i < books.size(); i++) {
                Integer userStudentNumber = books.get(i).getUserStudentNumber();
                User user = userDao.queryUserByStudentNumber(userStudentNumber);
                UserVo userVo = userChangeUserVo(user);
                BookVo bookVo = new BookVo();
                bookVo.setBookUserVo(userVo);
                bookVo.setBookName(books.get(i).getBookName());
                bookVo.setBookStatus(books.get(i).getBookStatus());
                bookVo.setBookPrice(books.get(i).getBookPrice());
                bookVos.add(bookVo);
            }
            return bookVos;
        }

    @Override
        public List<BookVo> queryBookByUserid(Integer userStudentNumber) throws SQLException, NoSuchFieldException, ClassNotFoundException, InstantiationException, IllegalAccessException {
            List<Book> books = bookMessageDao.queryBookByUserid(userStudentNumber);
            List<BookVo> bookVos = new ArrayList<>();
            for (int i = 0; i < books.size(); i++) {
                Integer userStudentNumber1 = books.get(i).getUserStudentNumber();
                User user = userDao.queryUserByStudentNumber(userStudentNumber1);
                UserVo userVo = userChangeUserVo(user);
                BookVo bookVo  = new BookVo();
                bookVo.setBookUserVo(userVo);
                bookVo.setBookName(books.get(i).getBookName());
                bookVo.setBookStatus(books.get(i).getBookStatus());
                bookVo.setBookPrice(books.get(i).getBookPrice());
                bookVos.add(bookVo);
            }
            return bookVos;
        }

    @Override
        public int insertBook(BookVo book) throws SQLException {
            Book newBook = new Book();
            newBook.setBookName(book.getBookName());
            newBook.setBookStatus(book.getBookStatus());
            newBook.setBookPrice(book.getBookPrice());
            newBook.setUserStudentNumber(book.getBookUserVo().getStudentNumber());
            int flag = bookMessageDao.insertBook(newBook);
            return flag;
        }

    @Override
        public int updateBook(BookVo book) throws SQLException {
            Book newBook = new Book();
            newBook.setBookName(book.getBookName());
            newBook.setBookStatus(book.getBookStatus());
            newBook.setBookPrice(book.getBookPrice());
            newBook.setUserStudentNumber(book.getBookUserVo().getStudentNumber());
            int flag = bookMessageDao.updateBook(newBook);
            return flag;
        }


        @Override
        public int deleteBook(Integer userStudentNumber, String bookName) throws SQLException {
            int flag = bookMessageDao.deleteBook(userStudentNumber, bookName);
            return flag;
        }

        public UserVo userChangeUserVo(User user){
            UserVo userVo = new UserVo();
            userVo.setStudentNumber(user.getStudentNumber());
            userVo.setName(user.getName());
            userVo.setAccountNumber(user.getAccountNumber());
            userVo.setGender(user.getGender());
            userVo.setPhone(user.getPhone());
            userVo.setPost(user.getPost());
            String duty = userDao.queryIdRole(user.getRoleId());
            userVo.setDuty(duty);
            return userVo;
        }
        public BookBorrowVo bookBorrowChangeBookBorrowVo(BookBorrow bookBorrow) throws SQLException, NoSuchFieldException, ClassNotFoundException, InstantiationException, IllegalAccessException {
            BookBorrowVo bookBorrowVo = new BookBorrowVo();
            Integer userStudentNumber = bookBorrow.getUserStudentNumber();
            User userUser = userDao.queryUserByStudentNumber(userStudentNumber);
            UserVo userVo = userChangeUserVo(userUser);
            bookBorrowVo.setBookUserVo(userVo);
            Integer borrowUserStudentNumber = bookBorrow.getBorrowUserStudentNumber();
            User userBorrow = userDao.queryUserByStudentNumber(borrowUserStudentNumber);
            UserVo userVo1 = userChangeUserVo(userBorrow);
            bookBorrowVo.setBorrowBookUserVo(userVo1);
            Book book = bookMessageDao.queryBookById(bookBorrow.getBookId());
            bookBorrowVo.setBookName(book.getBookName());
            bookBorrowVo.setBookStatus(book.getBookStatus());
            bookBorrowVo.setBookPrice(book.getBookPrice());
            bookBorrowVo.setBorrowBookTime(bookBorrow.getBorrowBookTime());
            bookBorrowVo.setReturnBookTime(bookBorrow.getReturnBookTime());
            return bookBorrowVo;
        }
}
