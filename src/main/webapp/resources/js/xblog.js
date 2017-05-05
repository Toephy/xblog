$(function () {

    $(".xfade").hide().fadeIn("slow");
    $(".animate_right").animate({left: '20px'}, "fast").animate({left: '0px'}, "normal");
    //$(".animate_left").animate({right:'10px'},"fast").animate({right:'0px'},"fast");

    $(".wangEditor-container").bind("click", function () {
        var uid = $("#uid").val();
        if (uid < 0) {
            alert("请先登录");
            return;
        }
    });

    var topexist = false;
    $(window).bind('scroll', function () {
        var len = $(this).scrollTop();
        if (len >= 500 && !topexist) {
            $("#fixed-list-group").append('<div id="gotop" class="list-group-item"><a href="javascript:void(0)" class="ico-bg gotop" onclick="xblog.pageScroll()"></a></div>');
            topexist = true;
        } else if (len < 500 && topexist) {
            $("#gotop").remove();
            topexist = false;
        }
    });

});

var xblog = {
    pageScroll: function () {
        $('html, body').animate({scrollTop: 0}, 'fast');//带动画
    }
};

var user = {
    exit: function () {
        $.ajax({
            url: "exit",
            async: false,
            success: function (data) {
                location.reload();
            }
        });
    }
};