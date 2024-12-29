package com.charity.utils;

/**
 * 消息数据处理
 * <p>

 *
 * 
 */
public class MessageUtils {

    /**
     * 文章/项目评论的内容处理
     * name 被评论的文章的名字 userName评论者的用户名 content消息内容 type文章/项目
     */
    public static String CommentHandle(String name, String userName, String content, Integer type) {
        String typeName = "";
        if (type == 1) {
            typeName = "项目";
        } else {
            typeName = "文章";
        }
        String content1 = "<b>" + userName + "</b> 评论了您的" + typeName + " <b><<" + name + ">></b> 内容如下： <b>" + content + "</b>";
        return content1;
    }

    /**
     * 文章/项目平路回复的消息处理
     */
    public static String relplyCommentHandle(String articleName, String userName, String content, Integer type) {
        String typeName = "";
        if (type == 1) {
            typeName = "项目";
        } else {
            typeName = "文章";
        }
        String content1 = "<b>" + userName + "</b> 回复了您关于" + typeName + " <b><<" + articleName + ">></b>的评论,内容如下： <b>" + content + "</b>";
        return content1;
    }

    /**
     * 文章审核消息处理
     * articleName 文章名字 flag为1表示通过审核，为2表示不通过审核 info处理信息
     */
    public static String articleCheckHandle(String articleName, Integer flag, String info) {
        String content = "";
        if (flag == 1) {
            content = "<b>恭喜您,您的文章</b><b><<" + articleName + ">>已通过审核!</b>";
        } else {
            content = "<b>很遗憾,您的文章</b><b><<" + articleName + ">>未通过审核!原因为:</b><b>" + info + "</b>";
        }
        return content;
    }

    /**
     * 认证审核消息处理
     * flag为1表示通c过审核，为2表示不通过审核 info处理信息
     */
    public static String certificationCheckHandle(Integer flag, String info) {
        String content = "";
        if (flag == 1) {
            content = "<b>恭喜您,您已成功通过认证!</b>";
        } else {
            content = "<b>很遗憾,您未能通过认证!原因为:</b><b>" + info + "</b>";
        }
        return content;
    }


}
