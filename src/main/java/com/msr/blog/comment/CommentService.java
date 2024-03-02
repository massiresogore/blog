package com.msr.blog.comment;

import com.msr.blog.MasUser.MasUser;
import com.msr.blog.MasUser.MasUserRepository;
import com.msr.blog.article.Article;
import com.msr.blog.article.ArticleRepository;
import com.msr.blog.system.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final ArticleRepository articleRepository;
    private final MasUserRepository masUserRepository;

    public CommentService(CommentRepository commentRepository, ArticleRepository articleRepository, MasUserRepository masUserRepository) {
        this.commentRepository = commentRepository;
        this.articleRepository = articleRepository;
        this.masUserRepository = masUserRepository;
    }

    public Comment commentArticle(String article, String manUser, String comment) {

       //Retrieve Article
       Article retrievedArticle = articleRepository.findById(Integer.parseInt(article)).orElseThrow(()-> new ObjectNotFoundException("article",Integer.parseInt(article)));

       //Retrieve ManUser
       MasUser retrievedManUser = masUserRepository.findById(Integer.parseInt(manUser)).orElseThrow(()-> new ObjectNotFoundException("manUser",Integer.parseInt(manUser)));

       //Comment
        Comment newComment = new Comment();
        newComment.setContent(comment);
        newComment.setArticle(retrievedArticle);
        newComment.setMasUser(retrievedManUser);

        //save
      return   commentRepository.save(newComment);

    }


    public List<Comment> findAll()
    {
        return this.commentRepository.findAll();
    }

    public Comment find(Integer id)
    {
        return this.commentRepository.findById(id)
                .orElseThrow(()-> new ObjectNotFoundException("comment", id));
    }

    public Comment update(Comment comment, Integer id)
    {
        Comment retrieved = this.find(id);
        retrieved.setContent(comment.getContent());

        return commentRepository.save(retrieved);
    }

    public void delete(Integer id)
    {
        Comment comment =  this.commentRepository.findById(id)
                .orElseThrow(()-> new ObjectNotFoundException("comment", id));
        this.commentRepository.delete(comment);
    }

}
