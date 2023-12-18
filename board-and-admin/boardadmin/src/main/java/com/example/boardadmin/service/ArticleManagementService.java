package com.example.boardadmin.service;

import com.example.boardadmin.dto.ArticleDto;
<<<<<<< HEAD
import com.example.boardadmin.dto.properties.ProjectProperties;
import com.example.boardadmin.dto.response.ArticleClientResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
=======
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
>>>>>>> afe78be51f842943efb30446e0adf2625baf151f

@RequiredArgsConstructor
@Service
public class ArticleManagementService {

<<<<<<< HEAD
    private final RestTemplate restTemplate;
    private final ProjectProperties projectProperties;


    public List<ArticleDto> getArticles() {
        URI uri = UriComponentsBuilder.fromHttpUrl(projectProperties.board().url() + "/api/articles")
                .queryParam("size", 10000) // TODO: 전체 게시글을 가져오기 위해 충분히 큰 사이즈를 전달하는 방식. 불완전하다.
                .build()
                .toUri();
        ArticleClientResponse response = restTemplate.getForObject(uri, ArticleClientResponse.class);

        return Optional.ofNullable(response).orElseGet(ArticleClientResponse::empty).articles();
    }

    public ArticleDto getArticle(Long articleId) {
        URI uri = UriComponentsBuilder.fromHttpUrl(projectProperties.board().url() + "/api/articles/" + articleId)
                .queryParam("projection", "withUserAccount")
                .build()
                .toUri();
        ArticleDto response = restTemplate.getForObject(uri, ArticleDto.class);

        return Optional.ofNullable(response)
                .orElseThrow(() -> new NoSuchElementException("게시글이 없습니다 - articleId: " + articleId));
    }

    public void deleteArticle(Long articleId) {
        URI uri = UriComponentsBuilder.fromHttpUrl(projectProperties.board().url() + "/api/articles/" + articleId)
                .build()
                .toUri();
        restTemplate.delete(uri);
    }

=======
    public List<ArticleDto> getArticles(){
        return List.of();
    }

    public ArticleDto getArticle(Long articleId){
        return null;
    }

    public void deleteArticle(Long articleId){

    }
>>>>>>> afe78be51f842943efb30446e0adf2625baf151f
}
