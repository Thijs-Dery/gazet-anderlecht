package org.example.anderlechtgazette.service;

import org.example.anderlechtgazette.model.Article;
import org.example.anderlechtgazette.repository.ArticleRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class ArticleService {
    private final ArticleRepository articleRepository;
    private final AtomicLong counter = new AtomicLong();

    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    public List<Article> getAllArticles() {
        return articleRepository.findAll();
    }

    public Article getArticleById(Long id) {
        return articleRepository.findById(id);
    }

    public void saveArticle(Article article) {
        if (article.getId() == null) {
            article.setId(counter.incrementAndGet());
        }
        articleRepository.save(article);
    }

    public void deleteArticle(Long id) {
        articleRepository.delete(id);
    }
}



