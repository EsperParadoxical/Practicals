package Demo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 151260D on 10/31/2016.
 */
/*
import Demo.BookDetails;

public class BookDBAO {


   public BookDetails createDummyBook(String BookID){
        BookDetails book = new BookDetails();
        book.setBookId(BookID);
        return book;
    }
*/
/*
    private BookDetails createDummyBook(String bookId) {
        BookDetails details = new BookDetails();
        details.setBookId(bookId);
        details.setDescription("Web components for developers talks about how web components can transfor the way you develop application for the web");
        details.setFirstName("Java");
        details.setSurname("Expert");
        details.setInventory(5);
        details.setOnSale(false);
        details.setPrice(5.9f);
        details.setTitle("Web components for developers");
        details.setYear(2015);
        return details;
    }

    public BookDetails getBookDetails(String bookId) {
        // return dummy book for testing now
        return createDummyBook(bookId);
    }

    public List<BookDetails> getAllBook() {
        ArrayList<BookDetails> list = new ArrayList<BookDetails>();
        for (int i=1; i<=5; i++) {
            BookDetails book = createDummyBook("100" + i);
            book.setTitle("Web components for developers Edition " + i);
            book.setInventory(i);
            book.setPrice(2+i);
            list.add(book);
        }
        return list;
    }
}
*/

    /**
     * Created by chitboon on 10/23/15.
     */
    public class BookDBAO {

        Connection con;
        // Database configuration
        public static String url = "jdbc:mysql://localhost/test";
        public static String dbdriver = "com.mysql.jdbc.Driver";
        public static String username = "root";
        public static String password = "mysql";

        // constructor to load the jdbc driver, exception will be thrown if database driver is not found
        public BookDBAO() throws Exception {
            Class.forName(dbdriver);
            con = DriverManager.getConnection(url, username, password);
        }
        // this is to make sure that connection is not null when you used it
        public void getConnection() throws SQLException {
            if (con == null) con = DriverManager.getConnection(url, username, password);
        }

        // Retrieve book details based on bookId, null is returned if book is not found
        public BookDetails getBookDetails(String bookId) {
            String sql = "select * from books where id = ?";
            BookDetails book = null;
            try {
                getConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
                pstmt.setString(1,bookId);
                ResultSet rs = pstmt.executeQuery();
                if (rs != null) {
                    rs.next();
                    book = new BookDetails();
                    book.setBookId(rs.getString("id"));
                    book.setDescription(rs.getString("description"));
                    book.setFirstName(rs.getString("first_name"));
                    book.setInventory(rs.getInt("inventory"));
                    book.setOnSale(rs.getBoolean("onSale"));
                    book.setPrice(rs.getFloat("price"));
                    book.setSurname(rs.getString("surname"));
                    book.setTitle(rs.getString("title"));
                    book.setYear(rs.getInt("calendar_year"));
                }
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return book;
        }

        public List<BookDetails> getAllBook() {
            String sql = "select * from books";
            ArrayList<BookDetails> list = new ArrayList<BookDetails>();
            try {
                getConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
                ResultSet rs = pstmt.executeQuery();
                while (rs != null && rs.next()) {
                    BookDetails book = new BookDetails();
                    book.setBookId(rs.getString("id"));
                    book.setDescription(rs.getString("description"));
                    book.setFirstName(rs.getString("first_name"));
                    book.setInventory(rs.getInt("inventory"));
                    book.setOnSale(rs.getBoolean("onSale"));
                    book.setPrice(rs.getFloat("price"));
                    book.setSurname(rs.getString("surname"));
                    book.setTitle(rs.getString("title"));
                    book.setYear(rs.getInt("calendar_year"));
                    list.add(book);
                }
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return list;
        }

    }