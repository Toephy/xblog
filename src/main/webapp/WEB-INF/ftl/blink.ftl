<!DOCTYPE html>
<html lang="zh-CN">
<head>
</head>
<body onload="blink()">
</body>

<script type="text/javascript">
    function blink() {
//        window.opener.location.reload();
//        window.opener.close();
//        alert(window.opener.location);
        window.location = window.opener.location;
//        location.reload(true);
//        window.opener.close();
    }
</script>

</html>