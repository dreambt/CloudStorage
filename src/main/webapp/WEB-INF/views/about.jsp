<%--
  关于我们
  User: baitao.jibt@gmail.com
  Date: 12-8-24
  Time: 下午21:21
--%>
<%@ page contentType="text/html;charset=UTF-8" session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
    <title>关于我们</title>
    <link href="${ctx}/static/js/fancyBox/jquery.fancybox.css" type="text/css" rel="stylesheet" />
    <script src="${ctx}/static/js/fancyBox/jquery.fancybox.pack.js" type="text/javascript"></script>
</head>
<body>
<div class="page page-ex">
    <h1>关于我们</h1>
    <p>我们相信做产品和做人是一样的，都要不断的完善并听取大家的意见.<br/>
        如果您有什么好的想法，可以发Email到 <a href="mailto:baitao.jibt@gmail.com">baitao.jibt[at]gmail.com</a> .</p>
    <div class="row-fluid team">
        <p class="span6 thumbnail">
            <a class="fancybox-effects" href="${ctx}/static/images/headPic/dreambt-big.jpg" title="纪柏涛 个人网站http://www.im47.cn"><img src="${ctx}/static/images/headPic/dreambt.jpg" width="120px" height="120px"/></a>
            <strong>纪柏涛 <br/>QQ: 125004628 <br/><a href="mailto:baitao.jibt@gmail.com" class="light" target="_blank">baitao.jibt[at]gmail.com</a><br/><a href="http://www.im47.cn" class="light" target="_blank">http://www.im47.cn</a></strong>
        </p>
        <p class="span6 thumbnail">
            <a class="fancybox-effects" href="${ctx}/static/images/headPic/dongpengfei-big.jpg" title="董鹏飞"><img src="${ctx}/static/images/headPic/dongpengfei.jpg" width="120px" height="120px"/></a>
            <strong>董鹏飞 <br/>QQ: 826323891 <br/><a href="mailto:pengfei.dongpf@gmail.com" class="light" target="_blank">pengfei.dongpf[at]gmail.com</a></strong>
        </p>
    </div>
    <div class="row-fluid team">
        <p class="span6 thumbnail">
            <a class="fancybox-effects" href="${ctx}/static/images/headPic/zhangnan-big.jpg" title="张楠"><img src="${ctx}/static/images/headPic/zhangnan.png" width="120px" height="120px"/></a>
            <strong>张楠 <br/>QQ: 491673282 <br/><a href="mailto:491673282@qq.com" class="light" target="_blank">491673282[at]qq.com</a></strong>
        </p>
    </div>
</div>
<script type="text/javascript">
    $(function(){
        // 激活导航栏
        $("#about-page").addClass("active");

        // fancyBox
        $(".fancybox-effects").fancybox({
            openEffect : 'elastic',
            openSpeed  : 150,

            closeEffect : 'elastic',
            closeSpeed  : 150,

            closeClick : true,

            helpers : {
                title : {
                    type : 'inside'
                }
            }
        });
    });
</script>
</body>
</html>