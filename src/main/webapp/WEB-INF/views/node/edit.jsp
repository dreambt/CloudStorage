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
        <div class="span12">
            <form:form modelAttribute="node" action="${ctx}/node/${action}" method="post">
            <table>
                <tr>
                    <td><label for="displayOrder">排列顺序</label></td>
                    <td><input type="hidden" name="id" value="${node.id}"/>
                        <input type="text" name="displayOrder" id="displayOrder" value="${node.displayOrder}"/></td>
                </tr>
                <tr>
                    <td><label for="name">分类名称</label></td>
                    <td><input type="text" name="name" id="name" value="${node.name}"/></td>
                </tr>
                <tr>
                    <td><label for="type">所属类型</label></td>
                    <td>
                        <form:select id="type" path="type" items="${types}" itemLabel="displayName" itemValue="value"></form:select>
                    </td>
                </tr>
                <tr>
                    <td><label for="parentId">上级分类</label></td>
                    <td><select id="parentId" name="parentId">
                        <c:forEach items="${nodes}" var="node" begin="0" step="1"><option value="${node.id}">${node.name}</option>
                            <c:if test="${not empty node.nodeList}">
                                <c:forEach items="${node.nodeList}" var="node2" begin="0" step="1"><option value="${node2.id}">${node.name} / ${node2.name}</option>
                                    <%--<c:if test="${not empty node2.nodeList}">--%>
                                        <%--<c:forEach items="${node2.nodeList}" var="node3" begin="0" step="1"><option value="${node3.id}">${node.name} / ${node2.name} / ${node3.name}</option>--%>
                                        <%--</c:forEach>--%>
                                    <%--</c:if>--%>
                                </c:forEach>
                            </c:if>
                        </c:forEach>
                    </select>
                    </td>
                </tr>
            </table>
                <button class="btn btn-primary" type="submit">确定</button>
                <a href="${ctx}/node/list"><button class="btn">取消</button></a>
            </form:form>
        </div>
    </div>
</div>
<script type="text/javascript">
    $(function(){
        $("#node-page").addClass("active");
        <%--<c:if test="${action =='create'}">$("input").val("");</c:if>
        <c:if test="${action =='update'}">$("#displayOrder").attr("disabled",true);</c:if>--%>
    });
</script>
</body>
</html>