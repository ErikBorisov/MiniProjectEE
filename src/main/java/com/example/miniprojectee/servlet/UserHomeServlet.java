package com.example.miniprojectee.servlet;

import com.example.miniprojectee.manager.UserManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "user-home", value = "/user-home", loadOnStartup = 1)
public class UserHomeServlet extends HttpServlet {
    private UserManager userManager;

    @Override
    public void init() throws ServletException {
        userManager = new UserManager();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Object currentUser = req.getSession().getAttribute("currentUser");
        if(currentUser!=null){
            req.getRequestDispatcher("WEB-INF/userHome.jsp").forward(req, resp);
        }else {
            resp.sendRedirect("/MiniProjectEE_war_exploded/sign-up");
        }

    }
}
