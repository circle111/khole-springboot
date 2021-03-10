package com.circle.controller.home;

import com.circle.enums.ArticleStatus;
import com.circle.pojo.Article;
import com.circle.pojo.Tag;
import com.circle.service.ArticleService;
import com.circle.service.TagService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(tags = "标签的获取")
@RestController
public class TagController {
    @Autowired
    private TagService tagService;

    @Autowired
    private ArticleService articleService;

    /**
     * 根据标签查询文章
     * @param tagId 标签ID
     * @return 模板
     */
    @ApiOperation(value = "根据标签id获取")
    @GetMapping("/tag/{tagId}")
    public Map getArticleListByTag(@PathVariable("tagId") Integer tagId,
                                      @RequestParam(required = false, defaultValue = "1") Integer pageIndex,
                                      @RequestParam(required = false, defaultValue = "10") Integer pageSize) {
        Map<String, Object> map = new HashMap<>();
        //该标签信息
        Tag tag = tagService.getTagById(tagId);
        if (tag == null) {
            return null;
        }
        map.put("tag", tag);
        //文章列表
        HashMap<String, Object> criteria = new HashMap<>(2);
        criteria.put("tagId", tagId);
        criteria.put("status", ArticleStatus.PUBLISH.getValue());
        PageInfo<Article> articlePageInfo = articleService.pageArticle(pageIndex, pageSize, criteria);
        map.put("pageInfo", articlePageInfo);
        //侧边栏
        //标签列表显示
        List<Tag> allTagList = tagService.listTag();
        map.put("allTagList", allTagList);
        //获得随机文章
        List<Article> randomArticleList = articleService.listRandomArticle(8);
        map.put("randomArticleList", randomArticleList);
        //获得热评文章
        List<Article> mostCommentArticleList = articleService.listArticleByCommentCount(8);
        map.put("mostCommentArticleList", mostCommentArticleList);
        map.put("pageUrlPrefix", "/tag?pageIndex");
        return map;
    }
}
