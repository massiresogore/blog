package com.msr.blog.category;

import com.msr.blog.article.Article;
import com.msr.blog.system.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {


    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category save(Category category)
    {
        return this.categoryRepository.save(category);
    }


    public List<Category> findAll()
    {
        return this.categoryRepository.findAll();
    }

    public Category find(Integer id)
    {
        return this.categoryRepository.findById(id)
                .orElseThrow(()-> new ObjectNotFoundException("category", id));
    }

    public Category update(Category category, Integer id)
    {
        Category retrived = this.find(id);
        retrived.setName(category.getName());

        return categoryRepository.save(retrived);
    }

    public void delete(Integer id)
    {
        Category category =  this.categoryRepository.findById(id)
                .orElseThrow(()-> new ObjectNotFoundException("category", id));
        this.categoryRepository.delete(category);
    }

}
