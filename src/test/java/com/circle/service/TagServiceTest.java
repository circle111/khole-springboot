package com.circle.service;

import com.circle.pojo.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class TagServiceTest {
    @Autowired
    private TagService tagService;

    @Test
    public void test1() {
        List<Tag> tags = tagService.listTag();
        Integer countTag = tagService.countTag();
        System.out.println("标签总数是：" + countTag);
        System.out.println("idf" + tagService.getTagById(1));
        System.out.println("naf" + tagService.getTagByName("Spring"));
        for (Tag tag : tags) {
            System.out.println(tag);
        }
    }

    @Test
    public void add() {
        Tag tag = new Tag();
        tag.setTagName("javascript");
        tag.setTagDescription("动态语言");
        tagService.insertTag(tag);
    }
    @Test
    public void delete() {
        Tag tag = new Tag(5);
        tagService.deleteTag(5);
    }
    @Test
    public void update() {
        Tag tag = new Tag(3, "Mybatis", "持久化框架", 1);
        tagService.updateTag(tag);
    }
    @Test
    public void getTest() {
        List<Tag> tags = tagService.listTagWithCount();
        for (Tag tag : tags) {
            System.out.println(tag);
        }

    }
}
