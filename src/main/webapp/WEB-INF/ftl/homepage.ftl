<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <#include "common.ftl">
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-12">
        <#include "header.ftl">
        </div>
    </div>
    <div class="row">
        <div class="col-md-3">
            <#include "side.ftl">
        </div>
        <div class="col-md-9 content">
            <div class="jumbotron well">
                <h2>
                    大美女
                </h2>
                <p>
                    ${content}
                </p>
                <p>
                    <a class="btn btn-primary btn-large" href="#">Learn more</a>
                </p>
            </div>
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
</body>
</html>