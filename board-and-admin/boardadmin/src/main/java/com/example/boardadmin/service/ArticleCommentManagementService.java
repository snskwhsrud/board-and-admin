package com.example.boardadmin.service;

import com.example.boardadmin.dto.ArticleCommentDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ArticleCommentManagementService {

    public List<ArticleCommentDto> getArticleComments() {
        return List.of();
    }

    public ArticleCommentDto getArticleComment(Long articleCommentId) {
        return null;
    }

    public void deleteArticleComment(Long articleCommentId) {

    }

}