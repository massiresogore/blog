package com.msr.blog.article;


import com.msr.blog.system.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ArticleService {
    private final ArticleRepository articleRepository;


    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    public List<Article> findAll()
    {
        return this.articleRepository.findAll();
    }

    public Article save(Article user)
    {
        return this.articleRepository.save(user);
    }

    public Article find(Integer id)
    {
        return this.articleRepository.findById(id)
                .orElseThrow(()-> new ObjectNotFoundException("article", id));
    }

    public Article update(Article article, Integer id)
    {
        Article retrived = this.find(id);
        retrived.setTitle(article.getTitle());
        retrived.setPrice(article.getPrice());
        retrived.setCategory(article.getCategory());

        return articleRepository.save(retrived);
    }

    public void delete(Integer id)
    {
        Article article =  this.articleRepository.findById(id)
                .orElseThrow(()-> new ObjectNotFoundException("article", id));
        this.articleRepository.delete(article);
    }

}
