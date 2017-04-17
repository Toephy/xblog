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
        <div class="col-md-3">
        <#include "side.ftl">
        </div>
        <div class="col-md-9">
            <div class="curtain">
                <div class="article_title">
                    <h1>${blog.blogTitle}</h1>
                </div>
                <div class="article_content">
                    <div class="markdown_views">
                    ${blog.blogContent}
                    </div>
                </div>
                <#--评论列表-->
                <div class="comment_list">
                    <div class="comment_item">
                        <div class="comment_header">
                            1楼
                            <span style="color: #369;">DYLM</span>
                            <span>2017-4-17 11:36:54发表</span>
                        </div>
                        <div class="comment_avatar">
                            <img src="http://avatar.csdn.net/6/1/E/3_heyijia0327.jpg" width="40" height="40">
                        </div>
                        <div class="comment_content">
                            哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈
                        </div>
                    </div>
                    <div class="comment_item">
                        <div class="comment_header">
                            2楼
                            <span style="color: #369;">DYLM</span>
                            <span>2017-4-17 11:36:54发表</span>
                        </div>
                        <div class="comment_avatar">
                            <img src="http://avatar.csdn.net/8/8/7/3_haithink.jpg" width="40" height="40">
                        </div>
                        <div class="comment_content">
                            12331231
                        </div>
                    </div>
                </div>

                <#include "editor_comment.ftl">
            </div>
        </div>
    </div>
</div>
</body>
</html>