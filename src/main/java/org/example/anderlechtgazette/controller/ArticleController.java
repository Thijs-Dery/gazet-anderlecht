package org.example.anderlechtgazette.controller;

import org.example.anderlechtgazette.model.Article;
import org.example.anderlechtgazette.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("articles", articleService.getAllArticles());
        return "index";
    }

    @GetMapping("/new")
    public String nieuwArtikel(Model model) {
        model.addAttribute("article", new Article());
        return "new";
    }

    @PostMapping("/save")
    public String bewaarArtikel(@ModelAttribute Article article) {
        if (!article.getReporterEmail().contains("@")) {
            return "new";
        }
        articleService.saveArticle(article);
        return "redirect:/";
    }

    @GetMapping("/details/{id}")
    public String details(@PathVariable Long id, Model model) {
        Article article = articleService.getArticleById(id);
        if (article == null) {
            // Handle the case where the article is not found
            return "redirect:/";
        }
        model.addAttribute("article", article);
        return "details";
    }
}






