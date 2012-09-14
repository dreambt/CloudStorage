<%--
  Created by IntelliJ IDEA.
  User: zhangnan
  Date: 12-9-14
  Time: 上午11:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>分类管理详细信息</title>
</head>
<body>
<div class="page">
    <div class="page-header">
        <h2>
            分类管理
            <small>欢迎进入分类管理</small>
        </h2>
    </div>
    <div class="row">
        <div class="span10 hero-unit">
            <form:form modelAttribute="node" action="${ctx}/node/${action}" id="saveM" method="get">
            <table>
                <tbody>
                <tr>
                    <td><label for="displayOrder">序号</label></td>
                    <td><input type="text" name="displayOrder" id="displayOrder" value=""/></td>
                    <td><label for="name">分类名称</label></td>
                    <td><input type="text" name="name" id="name" value=""/></td>
                    <td><label for="type">所属类型</label></td>
                    <td><input type="text" name="type" id="type" value=""/></td>
                    <td><label for="leftSibling">左兄弟</label></td>
                    <td><input type="text" name="leftSibling" id="leftSibling" value=""/></td>
                    <td><label for="parentId">父节点</label></td>
                    <td><input type="text" name="parentId" id="parentId" value=""/></td>
                </tr>
                </tbody>
                <tfoot>
                <button class="btn btn-primary">确定</button>
                <button class="btn">取消</button>
                </tfoot>
            </table>
            </form:form>
        </div>
    </div>
</div>
</body>
</html>