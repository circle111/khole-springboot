package com.circle.service;

import com.circle.enums.ArticleStatus;
import com.circle.mapper.ArticleMapper;
import com.circle.pojo.Article;
import com.github.pagehelper.PageInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;

@SpringBootTest
public class ArticleServiceTest {
    @Autowired
    private ArticleService articleService;
    @Autowired
    private ArticleMapper articleMapper;
    @Test
    public void test() {
        HashMap<String, Object> criteria = new HashMap<>(2);
        criteria.put("tagId", 3);
        criteria.put("status", 1);
        PageInfo<Article> articlePageInfo = articleService.pageArticle(1, 10, criteria);
        for (Article article : articlePageInfo.getList()) {
            System.out.println(article);
        }
        System.out.println(articlePageInfo.toString());
    }
    @Test
    public void test1() {
        HashMap<String, Object> criteria = new HashMap<>(2);
        criteria.put("tagId", 3);
        criteria.put("status", 1);
        List<Article> list = articleMapper.findAll(criteria);
        for (Article article : list) {
            System.out.println(article);
        }
    }
}
