package com.msr.blog.article;

import com.msr.blog.MasUser.MasUser;
import com.msr.blog.MasUser.MasUserService;
import com.msr.blog.category.Category;
import com.msr.blog.category.CategoryRepository;
import com.msr.blog.comment.Comment;
import com.msr.blog.comment.CommentService;
import org.springframework.data.relational.core.sql.In;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
@RequestMapping("articles")
public class ArtcileController {
    private final ArticleService articleService;
    private final CategoryRepository categoryRepository;
    private final CommentService commentService;
    private final MasUserService masUserService;

    public ArtcileController(ArticleService articleService, CategoryRepository categoryRepository, CommentService commentService, MasUserService masUserService) {
        this.articleService = articleService;
        this.categoryRepository = categoryRepository;
        this.commentService = commentService;
        this.masUserService = masUserService;
    }

    @GetMapping
    public String index(Model model)
    {
        model.addAttribute("categories", categoryRepository.findAll());
        model.addAttribute("article", new Article(null,"default titre",0, "default image"));
        model.addAttribute("articles", this.articleService.findAll());

        return "pages/article/index";
    }

    @PostMapping
    public String create(@ModelAttribute Article article, Model model)
    {
        //System.out.println(article);
        articleService.save(article);
        return "redirect:/articles";
    }
    @GetMapping("/edit/{id}")
    public String formToEdit(@ModelAttribute Article article,@PathVariable("id") String id, Model model)
    {
//        Article findArticle = articleService.find(Integer.parseInt(id));
        model.addAttribute("categories", categoryRepository.findAll());
        model.addAttribute("article", articleService.find(Integer.parseInt(id)) );
        return "pages/article/edit";
    }
    @PostMapping("/update")
    public String update(@ModelAttribute Article article, Model model)
    {
        articleService.update(article, article.getId());
//        System.out.println(article);
        return "redirect:/articles";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") String id)
    {
        articleService.delete(Integer.parseInt(id));
//        System.out.println(article);
        return "redirect:/articles";
    }

    @GetMapping("/comment/{id}")
    public String comment(@ModelAttribute Article article, @PathVariable("id") String id, Model model, Principal principal)
    {
        // recuperer larticle
        Article retrievedArticle = articleService.find(Integer.parseInt(id));
        //authUser
        MasUser userConnected = masUserService.findManUserByUsername(principal.getName());
        //System.out.println(  userConnected.getId());
        //recupéré ses commentaires

//        Article findArticle = articleService.find(Integer.parseInt(id));
        model.addAttribute("categories", categoryRepository.findAll());
        model.addAttribute("article", articleService.find(Integer.parseInt(id)) );
        model.addAttribute("comments",retrievedArticle.getComments());
        model.addAttribute("comment", new Comment());
        model.addAttribute("userId",userConnected.getId());
        return "pages/article/comment";
    }

    @PostMapping("/comment")
    public String comment(@RequestParam("article") String article, @RequestParam("manUser") String manUser ,@RequestParam("comment") String comment, Model model)
    {

      Comment newComment =  commentService.commentArticle(article, manUser,comment);
        return "redirect:/articles/comment/"+article;
    }
}
