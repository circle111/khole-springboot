package com.circle.mapper;

import com.circle.pojo.ArticleCategoryRef;
import com.circle.pojo.Category;
import com.circle.pojo.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ArticleCategoryRefMapperTest {
    @Autowired
    private ArticleCategoryRefMapper articleCategoryRefMapper;

    @Test
    public void test() {
        System.out.println("文章2的类别的数量有" + articleCategoryRefMapper.countArticleByCategoryId(2));
        System.out.println("文章1有下列的类别>");
        List<Category> categories = articleCategoryRefMapper.listCategoryByArticleId(1);
        for (Category category : categories) {
            System.out.println(category);
        }
        List<Integer> integers = articleCategoryRefMapper.selectCategoryIdByArticleId(1);
        for (Integer integer : integers) {
            System.out.println(integer);
        }
        System.out.println();
        integers = articleCategoryRefMapper.selectArticleIdByCategoryId(2);
        for (Integer integer : integers) {
            System.out.println(integer);
        }
    }
    @Test
    public void add() {
        articleCategoryRefMapper.insert(new ArticleCategoryRef(1,3));
    }
    @Test
    public void delelte() {
        articleCategoryRefMapper.deleteByCategoryId(2);
    }
}
