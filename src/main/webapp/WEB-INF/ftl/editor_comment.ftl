<div style="background: #fff;">
    <span class="ico_reply"></span>
    <span style="font-weight: 700;color: #000;">发表评论</span>
    <div id="comment" style="height:200px;max-height:300px;">
    </div>
</div>
<br>
<button id="submit_comment" type="button" class="btn btn-primary">发&nbsp;&nbsp;表</button>

<!--这里引用jquery和wangEditor.js-->
<script type="text/javascript">

    var editor = new wangEditor('comment');
    // 普通的自定义菜单
    editor.config.menus = [
        'emotion'
    ];
    editor.create();

    $("#submit_comment").click(function () {
        // 获取编辑器区域完整html代码
        var data1 = editor.$txt.html();

        // 获取编辑器纯文本内容
//        var data2 = editor.$txt.text();
        // 获取格式化后的纯文本
//        var data3 = editor.$txt.formatText();
        $.ajax({
            url: "comment",
            async: false,
            method: "POST",
            data:{comment:data1}
        });
    });
</script>