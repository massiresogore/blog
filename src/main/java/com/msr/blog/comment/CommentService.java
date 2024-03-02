package com.msr.blog.comment;

import com.msr.blog.article.Article;
import com.msr.blog.system.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
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
