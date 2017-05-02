<div style="background: #fff;padding-left: 12px"><h3>发表博客</h3></div>
<input id="edit_blog_uid" value="${session_uid?default('-1')}" style="display: none">
<div class="form-group">
    <label class="sr-only" for="name">标题</label>
    <input type="text" id="blog_title" class="form-control" placeholder="请输入标题">
</div>
<div id="edit_blog" style="height:800px;max-height:1200px;">
</div>
<br>
<button id="submit_blog" type="button" class="btn btn-primary">提&nbsp;&nbsp;交</button>

<!--这里引用jquery和wangEditor.js-->
<script type="text/javascript">
    var editor = new wangEditor('edit_blog');

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

    // 上传图片（举例）
    editor.config.uploadImgUrl = '/upload';

    // 配置自定义参数（举例）
    editor.config.uploadParams = {
        token: 'abcdefg',
        user: 'wangfupeng1988'
    };

    // 设置 headers（举例）
    editor.config.uploadHeaders = {
        'Accept' : 'text/x-json'
    };

    // 隐藏掉插入网络图片功能。该配置，只有在你正确配置了图片上传功能之后才可用。
//    editor.config.hideLinkImg = true;
    editor.create();

    $("#submit_blog").click(function () {

        var uid = $("#edit_blog_uid").val();

        if (uid < 0) {
            alert("请先登录");
            return;
        }

        var blogTitle = $("#blog_title").val();
        // 获取编辑器区域完整html代码
        var blogContent = editor.$txt.html();

        if (blogTitle.length <= 0 || blogContent.length <= 0) {
            alert("请输入标题或内容");
            return;
        }

        // 获取编辑器纯文本内容
//        var data2 = editor.$txt.text();
        // 获取格式化后的纯文本
//        var data3 = editor.$txt.formatText();
        $.ajax({
            url: "addblog",
            async: false,
            method: "POST",
            data: {
                uid: uid,
                title: blogTitle,
                content: blogContent
            },
            success: function (data, textStatus, jqXHR) {
                if (data) {
                    alert("提交成功");
                    location.reload();
                } else {
                    alert("提交失败");
                }
            }
        });
    });
</script>