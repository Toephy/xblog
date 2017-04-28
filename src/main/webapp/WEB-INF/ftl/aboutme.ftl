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
                <div style="margin-bottom: 5px;padding: 0 0 1px; overflow: hidden;border: 0 solid #F1D091;border-bottom-width: 1px;">
                    <h4>
                        ☞ 关于我
                    </h4>
                </div>
                <div class="article_content">
                    <div class="markdown_views">
                        ${content}
                    </div>
                </div>
            </div>

            <#--<#if (session_uid)?? && session_uid == 37>-->
                <#include "editor_aboutme.ftl">
            <#--</#if>-->
        </div>
    </div>
<#include "foot.ftl">
</div>
</body>
</html>