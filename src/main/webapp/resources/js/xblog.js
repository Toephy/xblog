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
});

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