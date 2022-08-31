package com.example.miniprojectee.servlet;

import com.example.miniprojectee.manager.UserManager;
import com.example.miniprojectee.models.User;
import com.example.miniprojectee.util.Md5Util;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "login", value = "/login", loadOnStartup = 1)
public class LoginServlet extends HttpServlet {
    private UserManager userManager;

    @Override
    public void init() throws ServletException {
        userManager = new UserManager();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("login_email");
        String password = req.getParameter("login_password");
        User currentUser = userManager.getByEmail(email);
        if (currentUser!=null && Md5Util.match(password, currentUser.getPassword())) {
            HttpSession session = req.getSession();
            session.setAttribute("currentUser", currentUser);
            resp.sendRedirect("/MiniProjectEE_war_exploded/user-home");
        } else {
            resp.sendRedirect("/MiniProjectEE_war_exploded/sign-in.jsp?log_error=invalid login or password");
        }
    }
}
