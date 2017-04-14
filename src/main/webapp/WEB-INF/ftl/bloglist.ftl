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
            <#list blogList as blog>
                <div class="jumbotron well">
                    <div class="article_title">
                        <h1>
                            <a href="blog/${blog.id}" target="_blank">
                                ${blog.blogTitle}
                            </a>
                        </h1>
                    </div>
                    <div class="article_content">
                        <div class="markdown_views">
                        ${blog.blogDesc}
                        </div>
                    </div>
                    <div class="article_manage">
                        <span style="margin: 0 5px 0 0;">${blog.createTime?string("yyyy-MM-dd HH:mm:ss")}</span>
                        <span>阅读次数(${blog.viewCount})</span>
                    </div>
                    <#--<p>-->
                        <#--<a class="btn btn-primary btn-large" href="#">Learn more</a>-->
                    <#--</p>-->
                </div>
            </#list>

            <ul class="pagination">
                <li>
                    <a href="#">Prev</a>
                </li>
                <li>
                    <a href="#">1</a>
                </li>
                <li>
                    <a href="#">2</a>
                </li>
                <li>
                    <a href="#">3</a>
                </li>
                <li>
                    <a href="#">4</a>
                </li>
                <li>
                    <a href="#">5</a>
                </li>
                <li>
                    <a href="#">Next</a>
                </li>
            </ul>
        </div>
    </div>
</div>
</body>
</html>