package com.charity.mapper;

import com.charity.entity.Article;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@Mapper
public interface ArticleMapper {

    /**
     * @param article 实例对象
     * @return 影响行数
     * 添加Article
     */
    int insert(Article article);

    /**
     * @param id 主键
     * @return 影响行数
     * 删除Article
     */
    int deleteById(Integer id);

    /**
     * @param uid 用户主键
     * @return 影响行数
     * 删除Article
     */
    int deleteByUserId(Integer uid);

    /**
     * @param id 主键
     * @return 实例对象
     * 查询单条数据
     */
    Article getById(Integer id);

    /**
     * @return 对象列表
     * 查询全部数据
     * 分页使用MyBatis的插件实现
     */
    List<Article> listArticles();

    /**
     * @param article 实例对象
     * @return 对象列表
     * 实体作为筛选条件查询数据
     */
    List<Article> listArticles(Article article);

    /**
     * @param article
     * @return 影响行数
     * 修改Article， 根据 article 的主键修改数据
     */
    int update(Article article);

    /**
     * 获取文章的数量
     */
    Integer countArticles(Article article);

    /**
     * 根据文章ID获取参加的活动
     */
    Article getActivityByArticleId(Integer id);

    /**
     * 根据文章标题，用户id获得文章
     */
    Article listArticleByTitle(@Param("title") String title, @Param("id") Integer id);

    /**
     * 增加阅读量
     */
    int addReadCount(Integer id);
}