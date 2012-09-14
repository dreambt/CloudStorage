<%--
  首页模板
  User: baitao.jibt@gmail.com
  Date: 12-5-4
  Time: 下午1:44
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="sitemesh" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title><sitemesh:title/></title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
    <meta http-equiv="Cache-Control" content="no-store" />
    <meta http-equiv="Pragma" content="no-cache" />
    <meta http-equiv="Expires" content="0" />

    <link href="${ctx}/static/bootstrap/css/bootstrap.min.css" type="text/css" rel="stylesheet"/>
    <link href="${ctx}/static/bootstrap/css/bootstrap-responsive.min.css" type="text/css" rel="stylesheet"/>
    <link href="${ctx}/static/js/msgUI/msgGrowl.css" type="text/css" rel="stylesheet"/>
    <link href="${ctx}/static/style/main.css" type="text/css" rel="stylesheet"/>
    <script src="${ctx}/static/js/jquery.min.js" type="text/javascript"></script>
    <sitemesh:head/>

    <!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]><script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script><![endif]-->

    <!-- Le fav and touch icons -->
    <link rel="shortcut icon" href="${ctx}/static/favicon.ico">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="${ctx}/static/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="${ctx}/static/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="${ctx}/static/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="${ctx}/static/ico/apple-touch-icon-57-precomposed.png">
</head>
<body data-spy="scroll" data-target=".subnav" data-offset="50">
<div class="container">
    <%@ include file="/WEB-INF/layouts/header.jsp" %>
    <sitemesh:body/>
    <%@ include file="/WEB-INF/layouts/footer.jsp" %>
</div>
<c:if test="${not empty info}">
    <div class="tips alert alert-info fade in">
        <button type="button" class="close" data-dismiss="alert">×</button>
        <h4>提示!</h4>
            ${info}
    </div>
</c:if>
<c:if test="${not empty error}">
    <div class="tips alert alert-error fade in">
        <button type="button" class="close" data-dismiss="alert">×</button>
        <h4>出错啦!</h4>
            ${error}
    </div>
</c:if>
<script src="${ctx}/static/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
<script src="${ctx}/static/js/msgUI/msgGrowl.js" type="text/javascript"></script>
</body>
</html>