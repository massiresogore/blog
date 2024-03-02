package com.msr.blog.comment;

import com.msr.blog.MasUser.MasUser;
import com.msr.blog.article.Article;
import jakarta.persistence.*;

@Entity
@Table(name = "comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String content;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Article article;

    @ManyToOne
    @JoinColumn(nullable = false)
    private MasUser masUser;


    public Comment() {
    }

    public Comment(Integer id, String content) {
        this.id = id;
        this.content = content;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public MasUser getMasUser() {
        return masUser;
    }

    public void setMasUser(MasUser masUser) {
        this.masUser = masUser;
    }

}
