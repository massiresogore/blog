package com.msr.blog.comment;

import com.msr.blog.MasUser.MasUser;
import com.msr.blog.article.Article;
import jakarta.persistence.*;

import java.util.Date;

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

    Date date = new Date();

    public Date getDate() {
        return date;
    }

    public Comment() {
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

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", article=" + article.getId() +
                ", masUser=" + masUser.getId() +
                '}';
    }
}
