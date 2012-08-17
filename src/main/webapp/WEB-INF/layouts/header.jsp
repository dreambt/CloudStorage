<%--
  页眉模板
  User: baitao.jibt@gmail.com
  Date: 12-5-4
  Time: 下午1:44
--%>
<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<div class="navbar navbar-fixed-top">
    <div class="navbar-inner">
        <div class="container">
            <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </a>
            <a class="brand" href="${ctx}">去这网</a>

            <div class="nav-collapse">
                <ul class="nav">
                    <li id="index-page"><a href="${ctx}">首页</a></li>
                    <li id="route-page"><a href="${ctx}/route">线路查询</a></li>
                    <li id="flight-page" class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">航班查询 <b class="caret"></b></a>
                        <ul class="dropdown-menu">
                            <li><a href="${ctx}/flight">机票查询</a></li>
                            <li><a href="${ctx}/airport">机场查询</a></li>
                        </ul>
                    </li>
                    <li id="train-page"><a href="${ctx}/train">火车查询(无效)</a></li>
                    <li id="hotel-page"><a href="${ctx}/hotel">酒店查询</a></li>
                    <li id="hotPoint-page"><a href="${ctx}/hotPoint">景点查询</a></li>
                    <li id="guide-page"><a href="${ctx}/guide">攻略查询(无效)</a></li>
                    <li id="about-page"><a href="${ctx}/about">关于我们</a></li>
                </ul>
                <form class="navbar-search pull-left" action="">
                    <input type="text" class="search-query span2" placeholder="Search">
                </form>
            </div>
            <!-- /.nav-collapse -->
        </div>
    </div>
    <!-- /navbar-inner -->
</div>
<!-- /navbar -->