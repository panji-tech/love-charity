package com.charity.mapper;

import com.charity.entity.ArticleActivity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface ArticleActivityMapper {

    /**
     * @param articleActivity 实例对象
     * @return 影响行数
     * 添加ArticleActivity
     */
    int insert(ArticleActivity articleActivity);

    /**
     * @param id 主键
     * @return 影响行数
     * 删除ArticleActivity
     */
    int deleteById(Integer id);

    /**
     * @param articleId 文章ID
     * @return 影响行数
     * 删除ArticleActivity
     */
    int deleteByArticleId(Integer articleId);

    /**
     * @param activityId 活动ID
     * @return 影响行数
     * 删除ArticleActivity
     */
    int deleteByActivityId(Integer activityId);

    /**
     * @param id 主键
     * @return 实例对象
     * 查询单条数据
     */
    ArticleActivity getById(Integer id);

    /**
     * @return 对象列表
     * 查询全部数据
     * 分页使用MyBatis的插件实现
     */
    List<ArticleActivity> listArticleActivitys();

    /**
     * @param articleActivity 实例对象
     * @return 对象列表
     * 实体作为筛选条件查询数据
     */
    List<ArticleActivity> listArticleActivitys(ArticleActivity articleActivity);

    /**
     * @param activityId 活动文章的ID
     * @return 文章数
     * 获取参与活动的文章数量（已发布状态）
     */
    Integer countArticle(Integer activityId);

    /**
     * @param articleActivity
     * @return 影响行数
     * 修改ArticleActivity， 根据 articleActivity 的主键修改数据
     */
    int update(ArticleActivity articleActivity);


}