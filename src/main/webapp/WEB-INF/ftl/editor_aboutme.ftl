<div style="background: #fff;margin-bottom: 20px;">
    <div style=" min-height: 40px;">
        <span class="ico_reply"></span>
        <span style="font-weight: 700;color: #000;">编辑关于博主</span>
        <input id="uid" value="${session_uid?default('-1')}" style="display: none">
        <#if userAvatar?exists>
            <div style="float: right;">
                <a href="javascript:void(0);" onclick="user.exit()">
                    <span title="退出登录" class="glyphicon glyphicon-off"></span>
                </a>
                <span>${nickname}</span>
                <img src="${userAvatar}" width="40" height="40">
            </div>
        </#if>
    </div>
    <div id="comment" style="height:200px;max-height:300px;">
    </div>
    <br>
    <button id="submit_aboutme" type="button" class="btn btn-primary">提&nbsp;&nbsp;交</button>
</div>

<!--这里引用jquery和wangEditor.js-->
<script type="text/javascript">

    var editor = new wangEditor('comment');
    // 普通的自定义菜单
    editor.config.menus = [
        'source',
        'insertcode',
        'img',
        '|',
        'bold',
        'underline',
        'italic',
        'strikethrough',
        'eraser',
        'forecolor',
        'bgcolor',
        '|',
        'quote',
        'fontfamily',
        'fontsize',
        'head',
        'unorderlist',
        'orderlist',
        'alignleft',
        'aligncenter',
        'alignright',
        '|',
        'link',
        'unlink',
        'table',
        'emotion',
//        '|',
//        'video',
//        'location',
        '|',
        'undo',
        'redo',
        'fullscreen'
    ];
    editor.create();

    $("#submit_aboutme").click(function () {

        var uid = $("#uid").val();
        if (uid < 0) {
            alert("请先登录");
            return;
        }

        // 获取编辑器区域完整html代码
        var data1 = editor.$txt.html();

        $.ajax({
            url: "editaboutme",
            async: false,
            method: "POST",
            data: {uid: uid, content: data1},
            success: function (data) {
                if (data) {
                    alert("修改成功");
                } else {
                    alert("修改失败");
                }
                location.reload();
            }
        });
    });
</script>