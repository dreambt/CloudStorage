<%--
  页脚模板
  User: baitao.jibt@gmail.com
  Date: 12-5-4
  Time: 下午1:44
--%>
<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="ctx" value="${pageContext.request.contextPath}" />
<footer class="footer">
    <p class="pull-right"><a href="#">Back to top</a></p>
    <p>Designed and built with all the love in the world by <a href="${ctx}/about">Our Team</a>.</p>
    <p>Code licensed under the <a href="http://www.apache.org/licenses/LICENSE-2.0" target="_blank">Apache License v2.0</a>. Documentation licensed under <a href="http://creativecommons.org/licenses/by/3.0/">CC BY 3.0</a>.</p>
    <p>Icons from <a href="http://glyphicons.com">Glyphicons Free</a>, licensed under <a href="http://creativecommons.org/licenses/by/3.0/">CC BY 3.0</a>.</p>
</footer>