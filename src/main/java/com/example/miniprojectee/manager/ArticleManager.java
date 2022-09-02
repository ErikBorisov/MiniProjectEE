package com.example.miniprojectee.manager;

import lombok.SneakyThrows;
import com.example.miniprojectee.models.Article;
import com.example.miniprojectee.models.User;
import com.example.miniprojectee.provider.DBConnectionProvider;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class ArticleManager {

    Logger logger = Logger.getLogger(UserManager.class.getName());
    private final Connection connection = DBConnectionProvider.getInstance().getConnection();
    private final CommentManager commentManager = new CommentManager();

    @SneakyThrows
    public Article save(Article article) {
        String sql = "insert into articles " +
                "(title, content, user_id)" +
                " values (?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, article.getTitle());
        preparedStatement.setString(2, article.getContent());
        preparedStatement.setInt(3, article.getUserId());

        int execute = preparedStatement.executeUpdate();
        ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
        generatedKeys.next();
        int userId = generatedKeys.getInt(1);
        logger.info("New article created: " + article);
        article.setId(userId);
        return article;
    }


    @SneakyThrows
    public List<Article> add(Article article) {
        List<Article> articles = new ArrayList<>();
        String query = "SELECT articles.*, users.name, users.surname \n" +
                "FROM articles\n" +
                "INNER JOIN users ON users.id = articles.`user_id`";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        while (resultSet.next()) {
            articles.add(Article.builder()
                    .id(article.getId())
                    .title(article.getTitle())
                    .content(article.getContent())
                    .userId(article.getUserId())
                    .author(User.builder()
                            .name(resultSet.getString("name"))
                            .surname(resultSet.getString("surname"))
                            .build())
                    .build());
        }
        return articles;
    }


    @SneakyThrows
    public List<Article> articlesByAuthor(User author) {
        List<Article> articles = new ArrayList<>();
        PreparedStatement statement = connection.prepareStatement("select * from articles where user_id = ?");
        statement.setInt(1, author.getId());
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String title = resultSet.getString("title");
            String content = resultSet.getString("content");
            Article article = Article.builder()
                    .id(id)
                    .title(title)
                    .content(content)
                    .author(author)
                    .userId(author.getId())
                    .build();
            article.setComments(commentManager.commentsByArticle(article));
            articles.add(article);
        }
        return articles;
    }

    @SneakyThrows
    public List<Article> all() {
        List<Article> articles = new ArrayList<>();
        String sql = "select a.*, u.name, u.surname, u.email from articles a " +
                "inner join users u on a.user_id = u.id";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            Article article = Article.builder()
                    .id(resultSet.getInt("id"))
                    .title(resultSet.getString("title"))
                    .content(resultSet.getString("content"))
                    .userId(resultSet.getInt("user_id"))
                    .author(User.builder()
                            .name(resultSet.getString("name"))
                            .surname(resultSet.getString("surname"))
                            .build())
                    .build();
            article.setComments(commentManager.commentsByArticle(article));
            articles.add(article);
        }
        return articles;
    }

    @SneakyThrows
    public boolean deleteArticleById(int id) {
//        String query = "delete from articles where id = ?";
        String query = "delete from articles inner join users on articles.user_id = users.id" +
                "where articles.id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, id);
        int updatedRowCount = preparedStatement.executeUpdate();
        return updatedRowCount > 0;
    }
    @SneakyThrows
    public void deleteArticle(int id,User user) {
        PreparedStatement statement1 = connection.prepareStatement("DELETE FROM articles WHERE ID = ? and user_ID = ?");
        statement1.setInt(1, id);
        statement1.setInt(2, user.getId());
        int i = statement1.executeUpdate();
        if (i > 0) System.out.println("Article deleted");
        else System.out.println("Wrong ID");
    }
    @SneakyThrows
    public boolean updateArticleById(int id, Article article) {
        String query = "update articles a set a.title = ?, a.content = ? where id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, article.getTitle());
        preparedStatement.setString(2, article.getContent());
        preparedStatement.setInt(3, id);
        int i = preparedStatement.executeUpdate();
        return i > 0;
    }
}
