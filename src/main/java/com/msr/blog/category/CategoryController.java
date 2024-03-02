package com.msr.blog.category;

import com.msr.blog.article.Article;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    public String create(@ModelAttribute Category category, Model model)
    {
        categoryService.save(category);
        return "redirect:/categories";
    }

    @GetMapping
    public String index(Model model)
    {
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("category", new Category(null, "default category"));
        return "pages/category/index";
    }

    @GetMapping("/edit/{id}")
    public String formToEdit(@ModelAttribute Category category, @PathVariable("id") String id, Model model)
    {
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("category", categoryService.find(Integer.parseInt(id)) );
        return "pages/category/edit";
    }
    @PostMapping("/update")
    public String update(@ModelAttribute Category category, Model model)
    {
        categoryService.update(category, category.getId());
        return "redirect:/categories";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") String id)
    {
        categoryService.delete(Integer.parseInt(id));
        return "redirect:/categories";
    }

}
