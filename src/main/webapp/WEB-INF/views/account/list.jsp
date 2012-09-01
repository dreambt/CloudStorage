<%--
  用户管理
  User: dengxiaolan(824688439@qq.com)
  Date: 12-9-1
  Time: 下午1:01.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
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
        <div class="span10 hero-unit">
            <div class="bs-docs-example">
                <%--//用户列表--%>
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th><label class="checkbox"><input id="checkedAll" type="checkbox" value=""></label></th>
                        <th>#</th>
                        <th>FTP账号</th>
                        <th>用户根路径</th>
                        <th>上传速度</th>
                        <th>下载速度</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td><label class="checkbox"><input type="checkbox" name="subBox" value=""></label></td>
                        <td>1</td>
                        <td class="userName"><a href="#" title="点击查看green的详细信息">green</a></td>
                        <td>ggg</td>
                        <td>6666</td>
                        <td>555</td>
                        <td>
                            <a href="#"><i class="icon-ok-sign" title="已审核"></i></a>
                            <a data-toggle="modal" href="#Tips" class="deleteSingleUser"><i class="icon-trash" title="删除"></i></a>
                            <a href="#"><i class="icon-edit" title="写权限"></i></a>
                        </td>
                    </tr>
                    <tr>
                        <td><label class="checkbox"><input type="checkbox" name="subBox" value=""></label></td>
                        <td>1</td>
                        <td class="userName"><a href="#" title="点击查看green的详细信息">green</a></td>
                        <td>ggg</td>
                        <td>6666</td>
                        <td>555</td>
                        <td>
                            <a href="#"><i class="icon-question-sign" title="未审核"></i></a>
                            <a data-toggle="modal" href="#Tips" class="deleteSingleUser"><i class="icon-repeat" title="找回"></i></a>
                            <a href="#"><i class="icon-ban-circle" title="无写权限"></i></a>
                        </td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
    <!--操作按钮-->
    <div class="row fileupload-buttonbar">
        <div class="span9">
            <a data-toggle="modal" href="#Tips" class="btn btn-warning cancel"id="auditAllUser">
                <i class="icon-ok-sign icon-white"></i>
                <span>批量审核</span>
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


</body>
</html>