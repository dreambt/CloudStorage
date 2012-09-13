<%--
  Created by IntelliJ IDEA.
  User: zhangnan
  Date: 12-8-27
  Time: 下午7:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

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
        <div class="accordion" id="accordion">
            <div class="accordion-group">
                <c:forEach items="${nodes}" var="node" begin="0" step="1">
                    <div class="accordion-heading">
                        <div class="bs-docs-example">
                            <table id="${node.id}${node.id}" class="table table-striped" align="center" width="500" cellpadding="0" cellspacing="0">
                                <tr>
                                    <td><label class="checkbox"><input type="checkbox" name="subBox" value=""></label></td>
                                    <td>${node.displayOrder}</td>
                                    <td><a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion" href="#collapse${node.id}">展开分类</a></td>
                                    <td class="nodeName">${node.name}</td>
                                    <td>${node.type}</td>
                                    <td>
                                        <i id="${node.id}" class="icon-trash deleteSingleNode" style="cursor: pointer" title="删除"></i>
                                        <a data-toggle="modal" href="#myModal" class="modify" name="${node.id}"><i class="icon-asterisk" title="修改"></i></a>
                                    </td>
                                    <td><a data-toggle="modal" href="#myModal" class="btn btn-link start click" name="${node.parentId}">
                                        <span>添加分类</span></a>
                                    </td>
                                </tr>
                            </table>
                        </div>
                    </div>
                    <div id="collapse${node.id}" class="accordion-body collapse">
                        <div class="accordion-inner">
                            <div class="accordion" id="accordion${node.id}">
                                <div class="accordion-group">
                                    <c:if test="${empty node.nodeList}">
                                        已是最后一级分类
                                    </c:if>
                                    <c:if test="${not empty node.nodeList}">
                                        <c:forEach items="${node.nodeList}" var="node2" begin="0" step="1">
                                            <div class="accordion-heading node${node2.id}">
                                                <div class="bs-docs-example">
                                                    <table id="${node2.id}${node2.id}" class="table table-striped" align="center" width="500" cellpadding="0" cellspacing="0">
                                                        <tr style="background: #D2E9FF">
                                                            <td><label class="checkbox"><input type="checkbox" name="subBox" value=""></label></td>
                                                            <td>${node2.displayOrder}</td>
                                                            <td><a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion${node.id}" href="#collapse${node2.id}">展开分类</a></td>
                                                            <td class="nodeName">${node2.name}</td>
                                                            <td>${node2.type}</td>
                                                            <td>
                                                                <i id="${node2.id}" class="icon-trash deleteSingleNode" style="cursor: pointer" title="删除"></i>
                                                                <a data-toggle="modal" href="#myModal" class="modify" name="${node2.id}"><i class="icon-asterisk" title="修改"></i></a>
                                                            </td>
                                                            <td><a data-toggle="modal" href="#myModal" class="btn btn-link start click" name="${node2.parentId}">
                                                                <span>添加分类</span></a>
                                                            </td>
                                                        </tr>
                                                    </table>
                                                </div>
                                            </div>
                                            <div id="collapse${node2.id}" class="accordion-body collapse">
                                                <div class="accordion-inner">
                                                    <div class="accordion" id="accordion${node2.id}">
                                                        <div class="accordion-group">
                                                            <c:if test="${empty node2.nodeList}">
                                                                已是最后一级分类
                                                            </c:if>
                                                            <c:if test="${not empty node2.nodeList}">
                                                                <c:forEach items="${node2.nodeList}" var="node3" begin="0" step="1">
                                                                    <div class="accordion-heading">
                                                                        <div class="bs-docs-example">
                                                                            <table id="${node3.id}${node3.id}" class="table table-striped" align="center" width="500" cellpadding="0" cellspacing="0">
                                                                                <tr style="background: #97CBFF">
                                                                                    <td><label class="checkbox"><input type="checkbox" name="subBox" value=""></label></td>
                                                                                    <td>${node3.displayOrder}</td>
                                                                                    <td><a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion${node2.id}" href="#collapse${node3.id}">展开分类</a></td>
                                                                                    <td class="nodeName">${node3.name}</td>
                                                                                    <td>${node3.type}</td>
                                                                                    <td>
                                                                                            <%--<a data-toggle="modal" id="${node3.id}" href="" class="deleteSingleNode"><i class="icon-trash" title="删除"></i></a>--%>
                                                                                        <i id="${node3.id}" class="icon-trash deleteSingleNode" style="cursor: pointer" title="删除"></i>
                                                                                        <a data-toggle="modal" href="#myModal" class="modify" name="${node3.id}"><i class="icon-asterisk" title="修改"></i></a>
                                                                                    </td>
                                                                                    <td><a data-toggle="modal" href="#myModal" class="btn btn-link start click" name="${node3.parentId}">
                                                                                        <span>添加分类</span></a>
                                                                                    </td>
                                                                                </tr>
                                                                            </table>
                                                                        </div>
                                                                    </div>
                                                                    <div id="collapse${node3.id}" class="accordion-body collapse">
                                                                        <div class="accordion-inner">
                                                                           已是最后一级分类
                                                                        </div>
                                                                    </div>
                                                                </c:forEach>
                                                            </c:if>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </c:forEach>
                                    </c:if>
                                </div>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>
</div>

<!--操作按钮-->
<div class="row fileupload-buttonbar">
    <div class="span9">
        <a data-toggle="modal" href="#Tips" class="btn btn-danger delete" id="deleteAllNode">
            <i class="icon-trash icon-white"></i>
            <span>批量删除</span>
        </a>
    </div>
</div>

</div>

<!--分类弹窗内容-->
<form:form modelAttribute="node" action="${ctx}/node/save" id="saveM" method="post">
    <div id="myModal" class="modal hide fade">
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
            <h3 id="myModalLabel">添加分类</h3>
        </div>
        <div class="modal-body">
            <span id="suggest" class="alert hide"></span>
            <input type="hidden" name="parentId" id="parentId" value="" />
            <label for="name">分类名称</label><input type="text" name="name" id="name" />
            <label for="type">分类类型</label>
            <form:select id="type" path="type" items="${types}" itemLabel="displayName" itemValue="value">
            </form:select>
            <label for="displayOrder">显示顺序</label><input type="text" name="displayOrder" id="displayOrder"/>
        </div>
        <div class="modal-footer">
            <button class="btn btn-primary" id="save">保存</button>
            <button class="btn" data-dismiss="modal">关闭</button>
        </div>
    </div>
</form:form>
<!--提示-->
<%--<div id="Tips" class="modal hide fade">
    <div class="modal-body">
    </div>
    <div class="modal-footer">
        <button class="btn btn-primary" id="ensure">确定</button>
        <button class="btn" data-dismiss="modal">取消</button>
    </div>
</div>--%>

<script type="text/javascript">
    $(function(){
        // 弹窗
        $("#myModal").modal('hide');

        //添加分类按钮触发取node.parentId和node.name
        var parentId;
        var nodeName;
        $(".click").click(function(){
            parentId=$(this).attr("name");
            $("#parentId").val(parentId);
            //禁止提交
            /*$("#save").attr("disabled",true);*/
        });

        //光标移入分类名称输入框事件
        /*$("#name").focus(function(){
            $(this).html('');
            $('#suggest').hide();
        });*/

        //添加分类光标移出分类名称输入框事件
        $("#name").blur(function(){
            nodeName=$("#name").val();
            $.ajax({
                url:"${ctx}/node/isUsedNodeName?parentId="+parentId+"&nodeName="+nodeName,
                success:function(data){
                    $('#suggest').show();
                    if(nodeName==''){
                        $('#suggest').text("请输入分类名称");
                        $("#save").attr("disabled",true);
                    }else if(true==data){
                        $('#name').css({'display':'block','color':'#f00'});
                        $('#suggest').text("该名称已存在，请更换");
                        $('#suggest').removeClass('alert-success').addClass('alert-error');
                        $("#save").attr("disabled",true);
                    } else {
                        $('#name').css({'display':'block','color':'#000'});
                        $('#suggest').removeClass('alert-error').addClass('alert-success');
                        $('#suggest').text("分类名可以使用");
                    }
                }
            });
        });

        //点击修改
        /*var nodeId;
        $(".modify").click(function(){
            parentId=$(this).attr("name");
            $("#parentId").val(parentId);
            nodeId=$(this).attr("name");
            $.ajax({
                url:"${ctx}/api/node/get/"+nodeId,
                success:function(data){
                    $('#name').val(data.name);
                    $('#type').val(data.type);
                    $('#displayOrder').val(data.displayOrder);
                }
            });
        });*/

       //删除
        $(".deleteSingleNode").click(function(){
            var id=$(this).attr("id");
            //当前节点的父类
            var parent=$(this).parent();
            //当前节点的父类
            var grand=parent.parent();
            //当前节点的所有兄弟节点
            var brother=grand.siblings();
            /*alert(parent);
            alert(grand);*/
            if(confirm("确定要删除吗？")){
                $.ajax({
                    url:"${ctx}/node/delete/"+id,
                    success:function(data){
                        $(".node"+id).remove();
                        $("#collapse"+id).remove();
                        alert("已删除！");
                       /* if (null == brother) {
                            $(parent).remove();
                            $(grand).remove();
                        }*/
                    }
                });
            }else{
                return false;
            }
        });

    });
</script>
</body>
</html>