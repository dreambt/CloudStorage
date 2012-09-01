<%--
  分类管理
  User: dengxiaolan(824688439@qq.com)
  Date: 12-8-31
  Time: 下午8:32.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>分类管理</title>
</head>
<body>
<div class="page">
    <div class="page-header">
        <h2>
            分类管理
            <small>欢迎进入分类管理</small>
        </h2>
    </div>
    <!--分类列表-->
    <div class="row">
        <div class="span10 hero-unit">
            <div class="bs-docs-example">

                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th><label class="checkbox"><input id="checkedAll" type="checkbox" value=""></label></th>
                        <th>#</th>
                        <th>名称</th>
                        <th>类型</th>
                        <th>操作</th>
                        <th>展开分类</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td><label class="checkbox"><input type="checkbox" name="subBox" value=""></label></td>
                        <td>1</td>
                        <td class="nodeName">java视频教程</td>
                        <td>MOVIE</td>
                        <td><a href="#"><i class="icon-ok-sign" title="已审核"></i></a>
                        <a data-toggle="modal" href="#Tips" class="deleteSingleNode"><i class="icon-repeat" title="找回"></i></a>
                        <a data-toggle="modal" href="#myModal"><i class="icon-asterisk" title="详细设置"></i></a></td>
                        <td><a href="#">展开分类</a></td>
                    </tr>
                    <tr>
                        <td><label class="checkbox"><input type="checkbox" name="subBox" value=""></label></td>
                        <td>1</td>
                        <td>PS视频教程</td>
                        <td>MOVIE</td>
                        <td><a href="#"><i class=" icon-question-sign" title="未审核"></i></a>
                            <a data-toggle="modal" href="#Tips" class="deleteSingleNode"><i class="icon-trash" title="删除"></i></a>
                            <a data-toggle="modal" href="#myModal"><i class="icon-asterisk" title="详细设置"></i></a></td>
                        <td><a href="#">展开分类</a></td>
                    </tr>
                    </tbody>
                </table>
            </div>
            </div>
        </div>
    <!--操作按钮-->
        <div class="row fileupload-buttonbar">
            <div class="span9">
                <a data-toggle="modal" href="#myModal" class="btn btn-primary start"><i class="icon-plus-sign icon-white"></i>
                    <span>添加分类</span></a>
                <a data-toggle="modal" href="#Tips" class="btn btn-danger delete" id="auditAllNode">
                    <i class="icon-ok-sign icon-white"></i>
                    <span>批量审核</span>
                </a>
                <a data-toggle="modal" href="#Tips" class="btn btn-danger delete" id="deleteAllNode">
                    <i class="icon-trash icon-white"></i>
                    <span>批量删除</span>
                </a>
            </div>
        </div>

</div>

<!--分类弹窗内容-->
<div id="myModal" class="modal hide fade">
    <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <h3 id="myModalLabel">添加分类</h3>
    </div>
    <div class="modal-body">
        <label for="name">分类名称</label><input type="text" name="name" id="name">
        <label for="parent">上级分类</label>
        <select id="parent">
            <option>1</option>
            <option>2</option>
        </select>
        <label for="type">分类类型</label>
        <select id="type">
            <option>movie</option>
            <option>pic</option>
        </select>
    </div>
    <div class="modal-footer">
        <button class="btn btn-primary">保存</button>
        <button class="btn" data-dismiss="modal">关闭</button>
    </div>
</div>

<!--提示-->
<div id="Tips" class="modal hide fade">
    <div class="modal-body">
    </div>
    <div class="modal-footer">
        <button class="btn btn-primary">确定</button>
        <button class="btn" data-dismiss="modal">取消</button>
    </div>
</div>

<script type="text/javascript">
    $(function(){
        // 弹窗
        $("#myModal").modal('hide');

        //双击展开分类
        $('tbody tr').dblclick(function(){
           alert("aa");
        });
    });
</script>
</body>
</html>