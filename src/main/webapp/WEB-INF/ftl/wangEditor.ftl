<div style="background: #fff;padding-left: 12px"><span>发表博客</span></div>
<div id="edit_blog" style="height:400px;max-height:500px;">
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
        // 获取编辑器区域完整html代码
        var data1 = editor.$txt.html();

        // 获取编辑器纯文本内容
//        var data2 = editor.$txt.text();
        // 获取格式化后的纯文本
//        var data3 = editor.$txt.formatText();
        $.ajax({
            url: "addblog",
            async: false,
            method: "POST",
            data:{
                content:data1
            },
            success: function (data, textStatus, jqXHR) {
                alert(data);
            }
        });
    });
</script>