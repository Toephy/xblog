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
        <div class="col-md-9 content">
            <#list blogList as blog>
                <div class="jumbotron well">
                    <h2>
                        ${blog.blogTitle}
                    </h2>
                    <p>
                    ${blog.blogContent}
                    </p>
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