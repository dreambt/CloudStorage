<%--
  首页模板
  User: baitao.jibt@gmail.com
  Date: 12-5-20
  Time: 下午18:25
--%>
<%@ page contentType="text/html;charset=UTF-8" session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>云存储</title>
</head>
<body data-spy="scroll" data-target=".subnav" data-offset="50">
<div class="page page-ex">
    <div class="hero-unit">
        <button class="close" data-dismiss="alert">×</button>
        <h1>开发中</h1>
        <h3>Hello boy, Hands up and Go away!</h3>
        <div class="progress progress-striped active">
            <div class="bar" style="width:10%;"></div>
        </div>
        <p>
            <a class="btn btn-primary btn-large" href="http://192.168.1.224" target="_block">Learn more</a>
        </p>
    </div>
</div>
<script type="text/javascript">
    function growl_type (e) {
        $.msgGrowl ({
            type: $(this).attr ('rel')
            , 'text': 'Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut.'
            , lifetime: 5000
        });
    }
    $(function(){
        // tips
        $('.btn').live ('click', growl_type);

        // 页面激活
        $("#index-page").addClass("active");
    });
</script>
</body>
</html>