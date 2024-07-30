package uz.app.jdbcapp.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import uz.app.jdbcapp.service.AuthService;

import java.io.IOException;

@WebServlet("/sign-in")
public class SignIn extends HttpServlet {
    AuthService authService = AuthService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("sign", false);
        req.getRequestDispatcher("views/auth.jsp").forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (authService.signIn(req, resp)) {
            req.getRequestDispatcher("/views/home.jsp").forward(req, resp);
        }
    }
}
