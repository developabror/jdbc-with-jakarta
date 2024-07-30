package uz.app.jdbcapp.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import uz.app.jdbcapp.service.AuthService;

import java.io.IOException;
import java.util.Random;

@WebServlet("/sign-up")
public class SignUp extends HttpServlet {
    AuthService authService = AuthService.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("sign",true);
        req.getRequestDispatcher("views/auth.jsp").forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (!authService.signUp(req,resp)) {
            resp.setContentType("text/html");
            resp.getWriter().write("<h1> this email already exists</h1> <a href='/sign-up'>sign up</a>");
            return;
        }
//        req.getRequestDispatcher("/views/home.jsp").forward(req, resp);
        resp.sendRedirect("/sign-in");
    }

}
