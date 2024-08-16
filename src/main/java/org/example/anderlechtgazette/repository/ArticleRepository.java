package org.example.anderlechtgazette.repository;

import org.example.anderlechtgazette.model.Article;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ArticleRepository {
    private final List<Article> articles = new ArrayList<>();

    public List<Article> findAll() {
        return new ArrayList<>(articles);
    }

    public Article findById(Long id) {
        return articles.stream().filter(a -> a.getId().equals(id)).findFirst().orElse(null);
    }

    public void save(Article article) {
        articles.add(article);
    }

    public void delete(Long id) {
        articles.removeIf(a -> a.getId().equals(id));
    }
}


