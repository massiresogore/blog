package com.msr.blog.article;

import com.msr.blog.category.Category;
import com.msr.blog.category.CategoryRepository;
import org.springframework.data.relational.core.sql.In;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("articles")
public class ArtcileController {
    private final ArticleService articleService;
    private final CategoryRepository categoryRepository;

    public ArtcileController(ArticleService articleService, CategoryRepository categoryRepository) {
        this.articleService = articleService;
        this.categoryRepository = categoryRepository;
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
}
