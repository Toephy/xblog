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
                <#include "editor_comment.ftl">
            </div>
        </div>
    </div>
</div>
</body>
</html>