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
                        --轻轻的你来了--
                    </h4>
                </div>


                <p>
                    留言板，留言板，留言板，留言板
                </p>

            <#if !session_uid?exists>
                <#include "loginthirdparty.ftl">
            </#if>

            <#include "editor_note.ftl">
            </div>
        </div>
    </div>
<#include "foot.ftl">
</div>

</body>
</html>