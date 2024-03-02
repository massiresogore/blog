package com.msr.blog;

import com.msr.blog.MasUser.MasUser;
import com.msr.blog.MasUser.MasUserService;
import com.msr.blog.article.ArticleService;
import com.msr.blog.comment.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BlogController {
    private final MasUserService masUserService;
    private final ArticleService articleService;
    private final CommentService commentService;


    public BlogController(MasUserService masUserService, ArticleService articleService, CommentService commentService) {
        this.masUserService = masUserService;
        this.articleService = articleService;
        this.commentService = commentService;
    }

    @GetMapping("/")
    public String index(Model model)
    {
        model.addAttribute("articles",articleService.findAll());
        model.addAttribute("users",masUserService.findAll());
        model.addAttribute("comments",commentService.findAll());

        return "index";
    }


}
