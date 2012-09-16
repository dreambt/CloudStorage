<%--
  用户详细信息
  User: dengxiaolan(824688439@qq.com)
  Date: 12-9-1
  Time: 下午2:02.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>用户详细信息</title>
</head>
<body>
<div class="page">
    <div class="page-header">
        <h2>
            用户管理
            <small>欢迎进入用户管理</small>
        </h2>
    </div>
    <!--分类列表-->
    <div class="row">
        <div class="span10 hero-unit">
            <form:form modelAttribute="ftpUser" action="${ctx}/ftpUser/${action}" method="post" autocomplete="false" >
                <table id="user" class="user-message" align="center">
                    <tbody>
                        <tr>
                            <td><label for="userName">FTP账号</label></td>
                            <td><input type="hidden" name="id" value="${ftpUser.id}"/>
                                <input type="text" name="userName" id="userName" value="${ftpUser.userName}"/></td>
                            <td><label for="userPassword">密码</label></td>
                            <td><input type="password" name="userPassword" id="userPassword" placeholder="加密信息"/></td>
                        </tr>
                        <tr>
                            <td><label for="homeDirectory">用户根路径</label></td>
                            <td><input type="text" name="homeDirectory" id="homeDirectory" value="${ftpUser.homeDirectory}"/></td>
                            <td><label for="writePermission">写权限</label></td>
                            <%--<td><input type="text" name="writePermission" id="writePermission" value="${ftpUser.writePermission}"/></td>--%>
                            <td><select id="writePermission"><option  value="${ftpUser.writePermission}">${ftpUser.writePermission}</option><c:choose><c:when test="${true==ftpUser.writePermission}"><option value="false">false</option></c:when><c:when test="${true!=ftpUser.writePermission}"><option value="true">true</option></c:when></c:choose></select></td>
                        </tr>
                        <tr>
                            <td><label for="enableFlag">是否可用</label></td>
                            <%--<td><input type="text" name="enableFlag" id="enableFlag" value="${ftpUser.enableFlag}"/></td>--%>
                            <td><select id="enableFlag"><option  value="${ftpUser.enableFlag}">${ftpUser.enableFlag}</option><c:choose><c:when test="${true==ftpUser.enableFlag}"><option value="false">false</option></c:when><c:when test="${true!=ftpUser.enableFlag}"><option value="true">true</option></c:when></c:choose></select></td>
                            <td><label for="idleTime">最大空闲时间</label></td>
                            <td><input type="text" name="idleTime" id="idleTime" value="${ftpUser.idleTime}"/></td>
                        </tr>
                        <tr>
                            <td><label for="uploadRate">上传速度</label></td>
                            <td><input type="text" name="uploadRate" id="uploadRate" value="${ftpUser.uploadRate}"/></td>
                            <td><label for="downloadRate">下载速度</label></td>
                            <td><input type="text" name="downloadRate" id="downloadRate" value="${ftpUser.downloadRate}"/></td>
                        </tr>
                        <tr>
                            <td><label for="maxLoginNumber">最大登陆次数</label></td>
                            <td><input type="text" name="maxLoginNumber" id="maxLoginNumber" value="${ftpUser.maxLoginNumber}"/></td>
                            <td><label for="maxLoginPerIp">最大登陆次数IP</label></td>
                            <td><input type="text" name="maxLoginPerIp" id="maxLoginPerIp" value="${ftpUser.maxLoginPerIp}"/></td>
                        </tr>

                        <tr>
                            <td><label for="createdDate">创建时间</label></td>
                            <td><input type="text" name="createdDate" id="createdDate" value="${ftpUser.createdDate}" disabled/></td>
                            <td><label for="lastModifiedDate">最后修改时间</label></td>
                            <td><input type="text" name="lastModifiedDate" id="lastModifiedDate" value="${ftpUser.lastModifiedDate}" disabled/></td>
                        </tr>
                    </tbody>
                    <tfoot>
                    <tr>
                        <td>
                            <button  class="btn btn-primary <c:if test="${action =='show'}">hide</c:if>" type="submit">保存</button>
                            <a href="${ctx}/ftpUser/list"><button class="btn">返回</button></a>
                        </td>
                    </tr>
                    </tfoot>
                </table>
            </form:form>
        </div>
    </div>
</div>
<script type="text/javascript">
    $(function(){
        $("#user-page").addClass("active");
        <c:if test="${action =='create'}">$("input").val("");$("select").val("");</c:if>
        <c:if test="${action =='show'}">$("input").attr("disabled",true);$("select").attr("disabled",true);</c:if>
    });
</script>
</body>
</html>