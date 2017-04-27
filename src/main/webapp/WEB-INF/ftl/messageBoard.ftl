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

            <#if noteList??&& (noteList?size > 0)>
                <#list noteList as note>
                    <div class="note-wrap">
                        <div class="note-inline-left">
                            <img src="${note.user.avatarurl}" width="40" height="40">
                            <div><span style="color: #999;">第${note.id}楼</span></div>
                        </div>
                        <div class="note-inline-right">
                            <div class="note-header">
                                <span style="color: #369;">${note.user.nickname}</span>
                                <span style="color: #999;">${note.createTime?string("yyyy-MM-dd HH:mm:ss")}</span>
                            </div>
                            <div>
                                ${note.content}
                            </div>
                        </div>
                    </div>
                </#list>
            <#else>
                <div class="note-wrap">
                    暂无留言，来一发
                </div>
            </#if>

            <br>
            <#import "pager.ftl" as p>
            <@p.pager pageNoS=pager.pageNo totalPageS=pager.totalPage toURL="${pager.toURL}"/>

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