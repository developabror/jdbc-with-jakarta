package uz.app.jdbcapp;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import uz.app.jdbcapp.entity.Role;
import uz.app.jdbcapp.entity.User;
import uz.app.jdbcapp.repository.UserRepository;

import java.io.IOException;
import java.util.Base64;
import java.util.Optional;

@WebFilter("/*")
public class Config implements Filter {
    UserRepository userRepository = UserRepository.getInstance();

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;

        Cookie identity = getCookie(req, "identity");
        if (req.getRequestURI().contains("/admin") ) {
            if (identity != null){
                Optional<User> optionalUser = userRepository.getUserById(new String(Base64.getDecoder().decode(identity.getValue().getBytes())));
                if (optionalUser.isPresent() && optionalUser.get().getRole().equals(Role.ADMIN)) {
                    filterChain.doFilter(servletRequest, servletResponse);
                    return;
                }
            }

            throw new RuntimeException("401 unauthorized");
        }
        System.out.println("here is users ip => " + servletRequest.getRemoteAddr());
        System.out.println(req.getRequestURI());
        System.out.println("-------------");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    public Cookie getCookie(HttpServletRequest request, String name) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(name)) {
                    return cookie;
                }
            }
        }
        return null;
    }
}
