package uz.app.jdbcapp.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import uz.app.jdbcapp.entity.Role;
import uz.app.jdbcapp.entity.User;
import uz.app.jdbcapp.service.AuthService;

import java.io.IOException;
import java.util.List;

@WebServlet("/sign-in")
public class SignIn extends HttpServlet {
    AuthService authService = AuthService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String dbAddress = getServletConfig().getInitParameter("db_address");
        req.setAttribute("sign", false);
//        resp.sendRedirect("views/index.jsp");
        req.getRequestDispatcher("views/index.jsp").forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        authService.signIn(req, resp);
            resp.sendRedirect("/home");


    }
}
