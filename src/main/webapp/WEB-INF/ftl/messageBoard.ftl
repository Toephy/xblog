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
            <div class="jumbotron well">
                <h2>
                    留言板
                </h2>
                <p>
                    留言板，留言板，留言板，留言板
                </p>
                <p>
                    <a class="btn btn-primary btn-large" href="#">Learn more</a>
                </p>
            </div>

        <#--<#include "addComment.ftl">-->
        <#include "wangEditor.ftl">

        </div>
    </div>
</div>

<script src="resources/js/jquery.min.js"></script>
<script src="resources/js/bootstrap.min.js"></script>
</body>
</html>