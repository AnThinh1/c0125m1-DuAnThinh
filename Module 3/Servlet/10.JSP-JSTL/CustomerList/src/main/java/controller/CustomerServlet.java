package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import model.Customer;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/abc")
public class CustomerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Customer> list = new ArrayList<>();
        list.add(new Customer("Mai Văn Hoàn", "1983-08-20", "Hà Nội", "images/anh1.jpg"));
        list.add(new Customer("Nguyễn Văn Nam", "1983-08-21", "Bắc Giang", "images/anh2.jpg"));
        list.add(new Customer("Nguyễn Thái Hòa", "1983-08-22", "Nam Định", "images/anh3.jpg"));
        list.add(new Customer("Trần Đăng Khoa", "1983-08-17", "Hà Tây", "images/anh4.jpg"));
        list.add(new Customer("Nguyễn Đình Thi", "1983-08-19", "Hà Nội", "images/anh5.jpg"));

        request.setAttribute("customerList", list);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
