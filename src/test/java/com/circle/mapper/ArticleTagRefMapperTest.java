package com.circle.mapper;

import com.circle.pojo.ArticleTagRef;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ArticleTagRefMapperTest {
    @Autowired
    private ArticleTagRefMapper articleTagRefMapper;

    @Test
    public void test() {
        System.out.println("标签1有多少篇文章：" + articleTagRefMapper.countArticleByTagId(1));
        System.out.println("文章2的标签列表" + articleTagRefMapper.listTagByArticleId(2));
    }
    @Test
    public void add() {
        articleTagRefMapper.insert(new ArticleTagRef(1, 2));
    }
    @Test
    public void deleteByArticleId() {
        articleTagRefMapper.deleteByArticleId(1);
    }
    @Test
    public void deleteByTagId() {
        articleTagRefMapper.deleteByTagId(1);
    }
}
