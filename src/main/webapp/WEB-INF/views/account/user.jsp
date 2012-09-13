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
            <form:form modelAttribute="user" action="${ctx}/account/user/save/${user.id}" id="saveM" method="post">
                <table id="user" class="user-message" align="center">
                    <tbody>
                        <tr>
                            <td><label for="userName">FTP账号</label></td>
                            <td><input type="text" name="userName" id="userName" value="${user.userName}"/></td>
                            <td><label for="userPassword">密码</label></td>
                            <td><input type="text" name="userPassword" id="userPassword" value="加密信息"/></td>
                        </tr>
                        <tr>
                            <td><label for="homeDirectory">用户根路径</label></td>
                            <td><input type="text" name="homeDirectory" id="homeDirectory" value="${user.homeDirectory}"/></td>
                            <td><label for="writePermission">写权限</label></td>
                            <td><input type="text" name="writePermission" id="writePermission" value="${user.writePermission}"/></td>
                        </tr>
                        <tr>
                            <td><label for="enableFlag">是否可用</label></td>
                            <td><input type="text" name="enableFlag" id="enableFlag" value="${user.enableFlag}"/></td>
                            <td><label for="idleTime">最大空闲时间</label></td>
                            <td><input type="text" name="idleTime" id="idleTime" value="${user.idleTime}"/></td>
                        </tr>
                        <tr>
                            <td><label for="uploadRate">上传速度</label></td>
                            <td><input type="text" name="uploadRate" id="uploadRate" value="${user.uploadRate}"/></td>
                            <td><label for="downloadRate">下载速度</label></td>
                            <td><input type="text" name="downloadRate" id="downloadRate" value="${user.downloadRate}"/></td>
                        </tr>
                        <tr>
                            <td><label for="maxLoginNumber">最大登陆次数</label></td>
                            <td><input type="text" name="maxLoginNumber" id="maxLoginNumber" value="${user.maxLoginNumber}"/></td>
                            <td><label for="maxLoginPerIp">最大登陆次数IP</label></td>
                            <td><input type="text" name="maxLoginPerIp" id="maxLoginPerIp" value="${user.maxLoginPerIp}"/></td>
                        </tr>

                        <tr>
                            <td><label for="createdDate">创建时间</label></td>
                            <td><input type="text" name="createdDate" id="createdDate" value="${user.createdDate}"/></td>
                            <td><label for="lastModifiedDate">最后修改时间</label></td>
                            <td><input type="text" name="lastModifiedDate" id="lastModifiedDate" value="${user.lastModifiedDate}"/></td>
                        </tr>
                    </tbody>
                    <tfoot>
                    <tr>
                        <td>
                            <c:choose>
                            <c:when test="${deal=='show'}">
                                <a href="${ctx}/ftpUser/list" style="color: #ffffff;"><button class="btn btn-primary">返回</button></a>
                            </c:when>
                            <c:when test="${deal=='edit'}">
                                <button  class="btn btn-primary" id="edit">保存修改</button>
                            </c:when>
                            <c:when test="${deal=='add'}">
                                <button class="btn btn-primary" id="add">添加</button>
                            </c:when>
                            </c:choose>
                        </td>
                        <td><a href="${ctx}/ftpUser/list"><button id="cancel" class="btn <c:if test="${deal=='show'}">hide</c:if>">取消</button></a></td></td>
                    </tr>
                    </tfoot>
                </table>
            </form:form>
        </div>
    </div>
</div>
<script type="text/javascript">
    $(function(){

        <c:if test="${deal =='add'}">$("input").val("");</c:if>

        <c:if test="${deal =='show'}">$("input").attr("disabled",true);</c:if>

        $("#edit").click(function(){
           $("#saveM").attr("action","${ctx}/ftpUser/save/${user.id}").submit();
        });
        $("#add").click(function(){
            $("#saveM").attr("action","${ctx}/ftpUser/save").submit();
        });
    });
</script>
</body>
</html>