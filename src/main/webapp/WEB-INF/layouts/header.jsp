<%--
  页眉模板
  User: baitao.jibt@gmail.com
  Date: 12-5-4
  Time: 下午1:44
--%>
<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>

<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!-- 导航栏 -->
<div class="navbar navbar-fixed-top">
    <div class="navbar-inner">
        <div class="container">
            <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </a>
            <a class="brand" href="${ctx}">网站名</a>
            <div class="nav-collapse">
                <ul class="nav">
                    <li id="index-page"><a href="${ctx}">首页</a></li>
                    <li id="file-page"><a href="${ctx}/file/list">文件管理</a></li>
                    <li id="sort-page"><a href="${ctx}/node/list">分类管理</a></li>
                    <li id="user-page"><a href="${ctx}/ftpUser/list">用户管理</a></li>
                    <li id="about-page"><a href="${ctx}/about">关于我们</a></li>
                </ul>
                <form class="navbar-search pull-right" action="">
                    <input type="text" class="search-query span2" placeholder="Search">
                </form>
                <ul class="nav pull-right">
                    <shiro:guest>
                        <li id="login-page"><a href="${ctx}/login">登录</a></li>
                        <li id="reg-page"><a href="${ctx}/reg">注册</a></li>
                    </shiro:guest>
                </ul>
            </div>
        </div>
    </div>
</div>