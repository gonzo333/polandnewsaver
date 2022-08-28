
package com.example.polandnewsaver;

import com.example.Article;
import com.example.polandnewsaver.common.FileOperation;
import com.example.polandnewsaver.model.NewsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api/news")
public class PolandNewsSaverController {
    private final NewsService newsService;
    //TODO - konfigurację pliku można przenieść do konfiguracji lub dodać jako parametr wywołania metody
    String TEXT_FILE = "C:/textFile.txt";
    FileOperation fileOperation = new FileOperation();

    public PolandNewsSaverController(NewsService newsService) {
        this.newsService = newsService;
    }

    @GetMapping("/buisness/poland/save")
    public List<Article> getBuisnessNewsPoland(Model model) {
        List<Article> polandBuisnessArticles = newsService.getNews();
        FileOperation fileWriter = new FileOperation();
        if (fileOperation.createFileIfNotExist(TEXT_FILE)) {
            polandBuisnessArticles.stream().forEach(article -> {
                        fileOperation.writeLineToFile(TEXT_FILE, article.getTitle() + ":" + article.getDescription() + ":" + article.getAuthor());
                    }
            );
        }
        return polandBuisnessArticles;
    }

}