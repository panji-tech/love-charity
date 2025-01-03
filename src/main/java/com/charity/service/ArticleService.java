package com.charity.service;

import com.charity.entity.Article;

import java.util.List;


public interface ArticleService {

    /**
     * 添加Article
     *
     * @param article 实例对象
     * @return 是否成功
     */
    boolean insert(Article article);

    /**
     * 参加活动
     *
     * @param articleId  文章ID
     * @param activityId 活动ID
     * @return 是否成功
     */
    boolean insertArticleActivity(Integer articleId, Integer activityId);

    /**
     * 删除参加的活动
     */
    boolean deleteArticleActivity(Integer articleId);

    /**
     * 删除活动
     */
    boolean deleteActivity(Integer activityId);

    /**
     * 删除Article
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    /**
     * 查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Article getById(Integer id);

    /**
     * 查询全部数据
     * 分页使用MyBatis的插件实现
     *
     * @return 对象列表
     */
    List<Article> listArticles();

    /**
     * 实体作为筛选条件查询数据
     *
     * @param article 实例对象
     * @return 对象列表
     */
    List<Article> listArticles(Article article);

    /**
     * 修改数据，哪个属性不为空就修改哪个属性
     *
     * @param article 实例对象
     * @return 是否成功
     */
    boolean update(Article article);

    /**
     * 根据文章ID获取参加的活动
     *
     * @param id 文章ID
     * @return 对象
     */
    Article getActivityByArticleId(Integer id);

    /**
     * 获取全部的文章
     *
     * @return 对象列表
     */
    List<Article> listAllArticles();

    /**
     * 获取全部的活动
     *
     * @return 对象列表
     */
    List<Article> listAllActivities();

    /**
     * 获取文章的数量
     */
    Integer countArticles();

    /**
     * 获取活动的数量
     */
    Integer countActivities();

    /**
     * 根据文章标题，用户id查找文章
     */
    Article listArticleByTitle(String title, Integer id);

    /**
     * 增加阅读量
     */
    int addReadCount(Integer id);

}