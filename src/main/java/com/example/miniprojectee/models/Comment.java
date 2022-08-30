package com.example.miniprojectee.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Comment {

    private int id;
    private String content;
    private int userId;
    private int articleId;
    private User author;

}
