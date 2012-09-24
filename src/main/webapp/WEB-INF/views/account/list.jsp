<%--
  用户管理
  User: zhangnan
  Date: 12-9-10
  Time: 上午10:01.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <title>用户管理</title>
</head>
<body>
<div class="page">
    <div class="page-header">
        <h2>
            用户管理
            <small>欢迎进入用户管理</small>
        </h2>
    </div>
    <div class="row">
        <div class="span12">
            <div class="well">
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th><label class="checkbox"><input id="checkedAll" type="checkbox" value=""></label></th>
                        <th>FTP账号</th>
                        <th>用户根路径</th>
                        <th>上传速度</th>
                        <th>下载速度</th>
                        <th>是否启用</th>
                        <th>写权限</th>
                        <th>是否删除</th>
                        <th>更多操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${ftpUsers}" var="ftpUser" begin="0" step="1">
                        <tr>
                            <td><label class="checkbox"><input type="checkbox" name="subBox" value=""></label></td>
                            <td class="userName click"><a href="${ctx}/ftpUser/get/${ftpUser.id}"title="点击查看详细信息">${ftpUser.userName}</a></td>
                            <td>${ftpUser.homeDirectory}</td>
                            <td>${ftpUser.kbUploadRate}</td>
                            <td>${ftpUser.kbDownloadRate}</td>
                            <td>
                                <a href="${ctx}/ftpUser/start/${ftpUser.id}"><c:choose><c:when test="${ftpUser.enableFlag}">启用</c:when><c:otherwise>停用</c:otherwise></c:choose></a>
                            </td>
                            <td>
                                <a href="${ctx}/ftpUser/allowWrite/${ftpUser.id}"><c:choose><c:when test="${ftpUser.writePermission}">有</c:when><c:otherwise>无</c:otherwise></c:choose></a>
                            </td>
                            <td>
                                <a href="${ctx}/ftpUser/delete/${ftpUser.id}"><c:choose><c:when test="${ftpUser.deleted}">删除</c:when><c:otherwise>找回</c:otherwise></c:choose></a>
                            </td>
                            <td>
                                <a href="${ctx}/ftpUser/update/${ftpUser.id}"><i class="icon-asterisk click" title="修改"></i></a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
    <!--操作按钮-->
    <div class="row fileupload-buttonbar">
        <div class="span9">
            <a data-toggle="modal" href="${ctx}/ftpUser/create" class="btn btn-primary">
                <i class="icon-user icon-white"></i>
                <span>添加用户</span>
            </a>
            <a data-toggle="modal" href="#Tips" class="btn btn-danger delete" id="deleteAllUser">
                <i class="icon-trash icon-white"></i>
                <span>批量删除</span>
            </a>
        </div>
    </div>
</div>

<!--提示-->
<div id="Tips" class="modal hide fade">
    <div class="modal-body">
        <p>确定要批量删除用户吗？</p>
    </div>
    <div class="modal-footer">
        <button class="btn btn-primary">确定</button>
        <button class="btn" data-dismiss="modal">取消</button>
    </div>
</div>
<script type="text/javascript">
    $(function(){
        $("#user-page").addClass("active");

        //全选
        $("#checkedAll").click(function(){
            if(this.checked){
                $("input[name='subBox']").each(function(){
                    this.checked=true;
                });
            }else{
                $("input[name='subBox']").each(function(){
                    this.checked=false;
                });
            }
        });
    });
</script>
</body>
</html>