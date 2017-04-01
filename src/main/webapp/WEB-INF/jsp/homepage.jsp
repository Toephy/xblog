<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>xblog</title>

    <!-- Bootstrap -->
    <link href="resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="resources/css/blog.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-12">
            <div class="page-header">
                <h1 style="color: white">
                    知行合一
                    <small style="color: white">不积跬步无以至千里</small>
                </h1>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-md-3">
            <div class="side">
                <%--<img alt="Bootstrap Image Preview" src="http://lorempixel.com/140/140/" class="img-circle"/>--%>
                <img alt="Bootstrap Image Preview" src="resources/image/avatar.png" class="img-circle avatar"/>
                <ul class="nav nav-pills nav-stacked">
                    <li class="active">
                        <a href="#">我的博客</a>
                    </li>
                    <li>
                        <a href="#">关于博主</a>
                    </li>
                    <li>
                        <a href="#">留言板</a>
                    </li>
                    <%--<li class="disabled">--%>
                    <%--<a href="#">disabled</a>--%>
                    <%--</li>--%>
                    <%--<li class="dropdown pull-right">--%>
                    <%--<a href="#" data-toggle="dropdown" class="dropdown-toggle">Dropdown<strong class="caret"></strong></a>--%>
                    <%--<ul class="dropdown-menu">--%>
                    <%--<li>--%>
                    <%--<a href="#">Action</a>--%>
                    <%--</li>--%>
                    <%--<li>--%>
                    <%--<a href="#">Another action</a>--%>
                    <%--</li>--%>
                    <%--<li>--%>
                    <%--<a href="#">Something else here</a>--%>
                    <%--</li>--%>
                    <%--<li class="divider">--%>
                    <%--</li>--%>
                    <%--<li>--%>
                    <%--<a href="#">Separated link</a>--%>
                    <%--</li>--%>
                    <%--</ul>--%>
                    <%--</li>--%>
                </ul>
            </div>
        </div>
        <div class="col-md-9 content">
            <div class="jumbotron well">
                <h2>
                    单目视觉里程计 mono vo
                </h2>
                <p>
                    之前为了改动svo进行了一些不同的尝试，两个视频demo在下面。效果1视频链接： https://v.qq.com/x/page/d0383rpx3ap.html在不同数据集上测试 效果2视频链接： https://v.qq.com/x/page/k03832nd7pu.htmlvo2对着天花板，用于室内机器人 vo2在euroc数据集上，无人机从起点飞出到飞回原点，可看到轨迹中起始点闭...
                </p>
                <p>
                    <a class="btn btn-primary btn-large" href="#">Learn more</a>
                </p>
            </div>
            <div class="jumbotron well">
                <h2>
                    Homography 知多少？
                </h2>
                <p>
                    在ORB-SLAM初始化的时候，作者提到，如果场景是平面，或者近似平面，或者低视差时，我们能应用单应性矩阵(homography)，这三种情形在我应用SVO的过程中颇有同感，打破了我对HH矩阵的固有映像，即只能用于平面或近似平面。但是我不知道如何去具体分析这里面的误差，比如不共面的情况时，应用HH矩阵将一个图像坐标从图像1投影到图像2时，它会落在图像哪个位置？和实际位置的误差该怎么计算？误差会有多...
                </p>
                <p>
                    <a class="btn btn-primary btn-large" href="#">Learn more</a>
                </p>
            </div>
            <div class="jumbotron well">
                <h2>
                    DSO 中的Windowed Optimization
                </h2>
                <p>
                    DSO中除了完善直接法估计位姿的误差模型外(加入了仿射亮度变换，光度标定，depth优化)，另一个核心就是像okvis一样使用sliding window来优化位姿，Engel也专门用了一节来介绍它。然而对于初次接触sliding window的初学者来说，这部分论文里使用的众多专业术语，如“First Estimate Jacobians”，“Marginalization”，“Schur co...
                </p>
                <p>
                    <a class="btn btn-primary btn-large" href="#">Learn more</a>
                </p>
            </div>
            <ul class="pagination">
                <li>
                    <a href="#">Prev</a>
                </li>
                <li>
                    <a href="#">1</a>
                </li>
                <li>
                    <a href="#">2</a>
                </li>
                <li>
                    <a href="#">3</a>
                </li>
                <li>
                    <a href="#">4</a>
                </li>
                <li>
                    <a href="#">5</a>
                </li>
                <li>
                    <a href="#">Next</a>
                </li>
            </ul>
        </div>
    </div>
</div>

<script src="resources/js/jquery.min.js"></script>
<script src="resources/js/bootstrap.min.js"></script>
</body>
</html>