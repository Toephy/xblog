<div class="fixed-side-menu">
    <div id="fixed-list-group" class="list-group">
    <#if !session_uid?exists>
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
    </#if>
    </div>
</div>