package com.example.productdiscountcalculator;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "DiscountServlet", value = "/display-discount")
public class DiscountServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String description = request.getParameter("description");
        float price = Float.parseFloat(request.getParameter("price"));
        float percent = Float.parseFloat(request.getParameter("percent"));

        float discountAmount = price * percent * 0.01f;
        float discountPrice = price - discountAmount;

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = response.getWriter();

        writer.println("<html><body>");
        writer.println("<h2>Discount Result</h2>");
        writer.println("<p><strong>Product:</strong> " + description + "</p>");
        writer.println("<p><strong>List Price:</strong> $" + price + "</p>");
        writer.println("<p><strong>Discount Percent:</strong> " + percent + "%</p>");
        writer.println("<p><strong>Discount Amount:</strong> $" + discountAmount + "</p>");
        writer.println("<p><strong>Discount Price:</strong> $" + discountPrice + "</p>");
        writer.println("</body></html>");
    }
}
