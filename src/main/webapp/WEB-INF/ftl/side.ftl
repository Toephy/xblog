<div class="side">
    <#assign active = Request.active/>
    <img alt="Bootstrap Image Preview" src="resources/image/avatar.png" class="img-circle avatar"/>
    <ul class="nav nav-pills nav-stacked">
        <#if active == "bloglist">
            <li class="active">
        <#else>
        <li>
        </#if>
            <a href="blog/list/1">我的博客</a>
        </li>

        <#if active == "writeblog">
        <li class="active">
        <#else>
        <li>
        </#if>
            <a href="writeblog">写博客</a>
        </li>

        <#if active == "aboutme">
        <li class="active">
        <#else>
        <li>
        </#if>
            <a href="aboutme">关于博主</a>
        </li>

        <#if active == "messageBoard">
        <li class="active">
        <#else>
        <li>
        </#if>
            <a href="messageBoard">留言板</a>
        </li>
    <#--<li class="disabled">-->
    <#--<a href="#">disabled</a>-->
    <#--</li>-->
    <#--<li class="dropdown pull-right">-->
    <#--<a href="#" data-toggle="dropdown" class="dropdown-toggle">Dropdown<strong class="caret"></strong></a>-->
    <#--<ul class="dropdown-menu">-->
    <#--<li>-->
    <#--<a href="#">Action</a>-->
    <#--</li>-->
    <#--<li>-->
    <#--<a href="#">Another action</a>-->
    <#--</li>-->
    <#--<li>-->
    <#--<a href="#">Something else here</a>-->
    <#--</li>-->
    <#--<li class="divider">-->
    <#--</li>-->
    <#--<li>-->
    <#--<a href="#">Separated link</a>-->
    <#--</li>-->
    <#--</ul>-->
    <#--</li>-->
    </ul>
</div>