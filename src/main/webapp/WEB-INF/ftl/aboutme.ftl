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
                    关于我
                </h2>
                <p>
                    窗前明月光，<br>
                    疑是地上霜。<br>
                    举头望明月，<br>
                    低头思故乡。<br>
                </p>
                <p>
                    <a class="btn btn-primary btn-large" href="#">Learn more</a>
                </p>
            </div>
            <#include "loginthirdparty.ftl">
        </div>
    </div>
</div>
</body>
</html>