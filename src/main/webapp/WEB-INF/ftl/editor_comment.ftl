<div style="background: #fff;margin-bottom: 20px;">
    <span class="ico_reply"></span>
    <span style="font-weight: 700;color: #000;">发表评论</span>
    <div id="comment" style="height:200px;max-height:300px;">
    </div>
    <br>
    <button id="submit_comment" type="button" class="btn btn-primary">发&nbsp;&nbsp;表</button>
</div>

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
        var blogId = $("#blog_id").val();
        // 获取编辑器纯文本内容
//        var data2 = editor.$txt.text();
        // 获取格式化后的纯文本
//        var data3 = editor.$txt.formatText();
        $.ajax({
            url: "addcomment",
            async: false,
            method: "POST",
            data: {blogId: blogId, comment: data1},
            success: function (data, textStatus, jqXHR) {
                alert("评论成功");
                location.reload();
            }
        });
    });
</script>