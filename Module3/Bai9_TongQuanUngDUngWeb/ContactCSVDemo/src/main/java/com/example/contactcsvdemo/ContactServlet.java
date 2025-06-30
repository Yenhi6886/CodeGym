package com.example.contactcsvdemo;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class ContactServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String filePath = request.getServletContext().getRealPath("/DemoData.csv");
        List<Contact> contactList = new ArrayList<>();
        File csvFile = new File(filePath);
        if (csvFile.exists()) {
            try (BufferedReader br = new BufferedReader(
                    new InputStreamReader(new FileInputStream(csvFile), StandardCharsets.UTF_8))) {

                String line;
                while ((line = br.readLine()) != null) {
                    if (line.trim().isEmpty() || line.toLowerCase().contains("tên") || line.toLowerCase().contains("name")) {
                        continue;
                    }
                    String[] parts = line.split(",", -1);
                    if (parts.length >= 6) {
                        String name = parts[1].trim();
                        String phone = parts[3].trim();
                        String email = parts[4].trim();
                        contactList.add(new Contact(name, phone, email));
                    }
                }

            } catch (Exception e) {
                request.setAttribute("error", "Lỗi khi đọc file: " + e.getMessage());
            }

        } else {
            request.setAttribute("error", "Không tìm thấy file dữ liệu DemoData.csv");
        }
        request.setAttribute("contacts", contactList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }
}
