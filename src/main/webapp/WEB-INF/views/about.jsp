<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="ctx" value="${pageContext.request.contextPath}" />
<html>
<head>
    <title>关于我们</title>
    <link href="${ctx}/static/js/fancyBox/jquery.fancybox.css" type="text/css" rel="stylesheet" />
    <script src="${ctx}/static/js/fancyBox/jquery.fancybox.pack.js" type="text/javascript"></script>
</head>
<body>
<div class="page page-ex">
    <h1>关于我们</h1>
    <p>我们都热爱尝试新鲜事物，我们同样喜欢记录我们阅读的知识并用之建立我们的知识库。
        然而，我们在网络上寻找、阅读、存储、检索和共享如此庞大的信息流让我们崩溃。因为，它们随机的分散在世界的每一个角落。</p>
    <p>我们的诞生正式因为这个令人崩溃的想法，我们希望通过我们的努力可以使你的工作更加条例，生活更有序。</p>
    <hr />
    <h2>关于团队</h2>
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