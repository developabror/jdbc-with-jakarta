package uz.app.jdbcapp.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import uz.app.jdbcapp.entity.Role;
import uz.app.jdbcapp.entity.User;
import uz.app.jdbcapp.service.AuthService;

import java.io.IOException;

@WebServlet("/home")
public class HomePage extends HttpServlet {
    AuthService authService = AuthService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (authService.authorization(req, resp)) {
            if (((User) req.getAttribute("user")).getRole().equals(Role.ADMIN)) {
                req.getRequestDispatcher("/views/admin-home.jsp").forward(req, resp);
            }
        }
        req.setAttribute("message","something went wrong please sign in again");
        req.getRequestDispatcher("/views/home.jsp").forward(req, resp);
    }
}
