package uz.app.jdbcapp.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import uz.app.jdbcapp.service.AuthService;

import java.io.IOException;
import java.util.Base64;

@WebServlet("/auth")
public class AuthController extends HttpServlet {
    AuthService authService =AuthService.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        authService.confirmEmail(req,resp);
        req.getRequestDispatcher("/views/home.jsp").forward(req, resp);
//        resp.setContentType("text/html");
//        resp.getWriter().write("<h1>confirmed successfully please <a href=\"/sign-in\">login</a></h1>");
    }
}
