<div class="side">
    <#assign active = Request.active/>
    <img alt="Bootstrap Image Preview" src="resources/image/avatar.png" class="img-circle avatar"/>
    <ul class="nav nav-pills nav-stacked">
        <#if active == "bloglist">
            <li class="active">
        <#else>
        <li>
        </#if>
            <a href="blog/list/1">博客列表</a>
        </li>

        <#if (session_uid)?? && session_uid == 37>
            <#if active == "writeblog">
            <li class="active">
            <#else>
            <li>
            </#if>
            <a href="writeblog">写博客</a>
            </li>
        </#if>

        <#if active == "messageBoard">
        <li class="active">
        <#else>
        <li>
        </#if>
            <a href="messageBoard">留言板</a>
        </li>

        <#if active == "aboutme">
        <li class="active">
        <#else>
        <li>
        </#if>
            <a href="aboutme">关于博主</a>
        </li>
    </ul>
</div>