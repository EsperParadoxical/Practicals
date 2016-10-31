package Demo;

/**
 * Created by 151260D on 10/31/2016.
 */

import Demo.BookDetails;

public class BookDBAO {


   /* public BookDetails createDummyBook(String BookID){
        BookDetails book = new BookDetails();
        book.setBookId(BookID);
        return book;
    }
*/

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
}
