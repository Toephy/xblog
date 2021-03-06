<!DOCTYPE html>
<html lang="zh-CN">
<head>
<#include "common.ftl">
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-12">
        <#include "header.ftl">
        </div>
    </div>
    <div class="row">
        <div class="col-md-3 xfade">
        <#include "side.ftl">
        </div>
        <div class="col-md-9 animate_right">
            <div class="curtain">
                <div class="article_title">
                    <input id="blog_id" value="${blog.id}" style="display: none">
                    <h1>${blog.blogTitle}</h1>
                </div>
                <div class="article_content">
                    <div class="markdown_views">
                    ${blog.blogContent}
                    </div>
                </div>
                <hr>
                <#--评论列表-->
                <div class="comment_list">
                <#if commentList??&& (commentList?size > 0)>
                    <#list commentList as item>
                        <div class="comment_item">
                            <div class="comment_header">
                                ${commentList?size - item_index}楼
                                <span style="color: #369;">${item.user.nickname}</span>
                                <span>${item.createTime?string("yyyy-MM-dd HH:mm:ss")}发表</span>
                            </div>
                            <div style="overflow:hidden;">
                                <div class="comment_avatar">
                                    <img src="${item.user.avatarurl}" width="40" height="40">
                                </div>
                                <div class="comment_content">
                                    ${item.commentContent}
                                </div>
                            </div>
                        </div>
                    </#list>
                <#else>
                    <div class="comment_item">
                        暂无评论，来一发吧！
                    </div>
                </#if>
                </div>

                <#if !session_uid?exists>
                    <#include "loginthirdparty.ftl">
                </#if>

                <#include "editor_comment.ftl">
            </div>
        </div>
    </div>
<#include "foot.ftl">
</div>
</body>
</html>