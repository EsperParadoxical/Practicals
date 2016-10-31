package Demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.*;

/**
 * Created by 151260D on 10/31/2016.
 */
@WebServlet(name = "HomeServlet")
public class HomeServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.println(getContent());
        out.close();
    }




    private String getContent() {
        BookDBAO bookdb = new BookDBAO();
        BookDetails book = new BookDetails();

        StringBuilder buffer = new StringBuilder();
        buffer.append("<html>"+"<head><title>Duke's Bookstore</title></head>");
        buffer.append("<body> + ")

        return “”;
    }
}