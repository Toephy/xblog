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
            <#list blogList as blog>
                <div class="curtain">
                    <div class="article_title">
                        <h1>
                            <a href="blog/${blog.id}">
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
                </div>
            </#list>

            <#import "pager.ftl" as p>
            <@p.pager pageNoS=pager.pageNo totalPageS=pager.totalPage toURL="${pager.toURL}"/>
        </div>
    </div>
<#include "foot.ftl">
</div>

<div class="fixed-side-menu">
    <div class="list-group">
        <div class="list-group-item">
            <a href="#" class="ico-bg qq"></a>
        </div>
        <div class="list-group-item">
            <a href="#" class="ico-bg weixin"></a>
        </div>
        <div class="list-group-item">
            <a class="ico-bg weibo"
               href="https://api.weibo.com/oauth2/authorize?client_id=1705470590&response_type=code&redirect_uri=http://www.toephy.com/weiboauthorize/callbak"
               target="_blank"
               title="微博账号登录"></a>
        </div>
        <div class="list-group-item">
            <a href="#" class="ico-bg gotop"></a>
        </div>
    </div>
</div>


</body>
</html>