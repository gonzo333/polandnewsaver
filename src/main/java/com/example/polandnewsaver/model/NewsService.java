package com.example.polandnewsaver.model;

import com.example.Article;
import com.example.News;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import org.springframework.http.HttpHeaders;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class NewsService {
    RestTemplate restTemplate = new RestTemplate();

    public List<Article> getNews() {
        HttpHeaders httpHeaders = new HttpHeaders();
        HttpEntity httpEntity = new HttpEntity(httpHeaders);

        ResponseEntity<News> buisnessNewsFromPoland = restTemplate.exchange("https://newsapi.org/v2/top-headlines?country=pl&category=business&apiKey=5b76a5fb44dc48aa94693490afc9b1a0",
                HttpMethod.GET,
                httpEntity,
                News.class);
        return buisnessNewsFromPoland.getBody().getArticles();
    }
}
