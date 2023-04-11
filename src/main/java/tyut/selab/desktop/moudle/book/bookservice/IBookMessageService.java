package tyut.selab.desktop.moudle.book.bookservice;

import tyut.selab.desktop.moudle.book.domain.vo.BookBorrowVo;
import tyut.selab.desktop.moudle.book.domain.vo.BookVo;

import java.sql.SQLException;
import java.util.List;

public interface IBookMessageService {
    /**
     * 查询借书记录
     * @return
     */
    List<BookBorrowVo> queryBorrowBookLog() throws SQLException, NoSuchFieldException, ClassNotFoundException, InstantiationException, IllegalAccessException;

    /**
     * 根据书/书的拥有者学号来查询名借书记录
     * @param bookBorrow
     * @return
     */
    List<BookBorrowVo> queryBorrowBookLog(BookBorrowVo bookBorrow) throws SQLException, NoSuchFieldException, ClassNotFoundException, InstantiationException, IllegalAccessException;

    /**
     * 查询全部图书
     * @return 图书列表
     */
    List<BookVo> queryAllBook() throws SQLException, NoSuchFieldException, ClassNotFoundException, InstantiationException, IllegalAccessException;

    /**
     * 通过图书名字查询图书
     * @param bookName 书名
     * @return 图书列表
     */
    List<BookVo> queryBookByBookName(String bookName) throws SQLException, NoSuchFieldException, ClassNotFoundException, InstantiationException, IllegalAccessException;

    /**
     * 通过用户id查询该用户的图书
     * @param userStudentNumber 用户学号
     * @return 图书列表
     */
    List<BookVo> queryBookByUserid(Integer userStudentNumber) throws SQLException, NoSuchFieldException, ClassNotFoundException, InstantiationException, IllegalAccessException;

    /**
     * 增加图书
     * @param book 书
     * @return 成功返回1，失败返回-1
     */
    int insertBook(BookVo book) throws SQLException;

    /**
     * 修改图书信息
     * @param book 更新
     * @return
     */
    int updateBook(BookVo book) throws SQLException;

    /**
     * 删除图书
     * @param userStudentNumber 用户学号
     * @param bookName 书名
     * @return 成功返回1，失败返回-1
     */
    int deleteBook(Integer userStudentNumber,String bookName) throws SQLException;
}
