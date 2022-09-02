package com.example.miniprojectee.servlet.comments;

import com.example.miniprojectee.manager.ArticleManager;
import com.example.miniprojectee.manager.CommentManager;
import com.example.miniprojectee.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "delete-comment", value = "/delete-comment", loadOnStartup = 1)
public class DeleteCommentServlet extends HttpServlet {
    private ArticleManager articleManager;
    private CommentManager commentManager;

    @Override
    public void init() throws ServletException {
        articleManager = new ArticleManager();
        commentManager = new CommentManager();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        commentManager.deleteFromMyArticles((Integer.parseInt(request.getParameter("ArticleId"))),
                (Integer.parseInt(request.getParameter("deletedCommentId"))),
                (User) request.getSession().getAttribute("currentUser"));
        response.sendRedirect("/MiniProjectEE_war_exploded/user-home");

    }
}
