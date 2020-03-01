package com.snail.test.repository;

import com.snail.test.es.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ArticleRepository extends ElasticsearchRepository<Article, Long> {
    Page<Article> findDistinctByTitleContainingOrContentContaining(String title, String content, Pageable pageable);
}