<%--
  User: zhangnan
  Date: 12-8-26
  Time: 下午4:32
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <title>文件管理</title>
    <link rel="stylesheet" href="${ctx}/static/js/filetree/jquery.treeview.css"/>
    <link rel="stylesheet" href="${ctx}/static/js/fileupload/jquery.fileupload-ui.css"/>
    <link rel="stylesheet" href="${ctx}/static/js/fancyBox/jquery.fancybox.css?v=2.0.5" type="text/css" media="screen" />
    <link rel="stylesheet" href="${ctx}/static/js/fancyBox/helpers/jquery.fancybox-buttons.css?v=2.0.5" type="text/css" media="screen" />
    <link rel="stylesheet" href="${ctx}/static/js/fancyBox/helpers/jquery.fancybox-thumbs.css?v=2.0.5" type="text/css" media="screen" />
</head>
<body>
<div class="page">
    <div class="page-header">
        <h2>文件管理 <small>欢迎进入文件管理</small></h2>
    </div>
    <div class="row">
        <!-- 目录树 -->
        <div class="span3">
            <div class="well" id="parent">
                <ul id="browser" class="filetree treeview">
                    <c:forEach items="${nodes}" var="node" begin="0" step="1">
                        <li class="closed"><span id="${node.id}" class="folder<c:if test="${empty node.nodeList}"> leafnode</c:if>">${node.name}</span>
                        <c:if test="${not empty node.nodeList}">
                        <ul>
                            <c:forEach items="${node.nodeList}" var="node2" begin="0" step="1">
                                <li class="expandable"><span id="${node2.id}" class="folder<c:if test="${empty node2.nodeList}"> leafnode</c:if>">${node2.name}</span>
                                    <c:if test="${not empty node2.nodeList}">
                                        <ul>
                                            <c:forEach items="${node2.nodeList}" var="node3" begin="0" step="1">
                                                <li class="closed expandable"><span id="${node3.id}" class="folder<c:if test="${empty node3.nodeList}"> leafnode</c:if>">${node3.name}</span></li>
                                            </c:forEach>
                                        </ul>
                                    </c:if>
                                </li>
                            </c:forEach>
                        </ul>
                        </c:if>
                        </li>
                    </c:forEach>
                </ul>
            </div>
        </div>

        <!-- 文件列表 -->
        <div class="span9">
            <div class="well">
                <div id="file-list" class="hide">
                    <!-- 文件列表 -->
                    <table class="table table-hover">
                        <thead>
                        <tr>
                            <th><label class="checkbox"><input id="checkedAll" type="checkbox" value=""></label></th>
                            <th>文件名</th>
                            <th>类型</th>
                            <th>大小</th>
                            <th>日期</th>
                            <th>MD5</th>
                            <th>常用操作</th>
                            <th>管理操作</th>
                        </tr>
                        </thead>
                        <tbody id="file-items"></tbody>
                    </table>
                </div>

                <!-- 分页 -->
                <div class="pagination pagination-right">
                    <ul id="pagination">
                    </ul>
                </div>










            <%--<form id="fileupload" action="file/save" method="post" enctype="multipart/form-data" style="height: 40px;">--%>
            <div class="row fileupload-buttonbar">
                <div class="span9">
                    <!-- The fileinput-button span is used to style the file input field as button -->
                        <span class="btn btn-success fileinput-button">
                            <i class="icon-plus icon-white"></i>
                            <span>选择文件...</span>
                            <input type="file" name="files[]" multiple="" id="choosefile"/>
                        </span>
                    <button type="submit" class="btn btn-primary start">
                        <i class="icon-upload icon-white"></i>
                        <span>开始上传</span>
                    </button>
                    <button type="reset" class="btn btn-warning cancel">
                        <i class="icon-ban-circle icon-white"></i>
                        <span>取消上传</span>
                    </button>
                    <button type="button" class="btn btn-danger delete">
                        <i class="icon-trash icon-white"></i>
                        <span>删除</span>
                    </button>
                    <input type="checkbox" class="toggle"/> 全选
                </div>
                <!-- The global progress information -->
                <div id="gp_information" class="span5 fileupload-progress fade" style="display: none">
                    <!-- The global progress bar -->
                    <div class="progress progress-success progress-striped active" role="progressbar" aria-valuemin="0" aria-valuemax="100" aria-valuenow="0">
                        <div class="bar" style="width: 0%; "></div>
                    </div>
                    <!-- The extended global progress information -->
                    <div class="progress-extended">&nbsp;</div>
                </div>
            </div>
            <!-- The loading indicator is shown during file processing -->
            <div class="fileupload-loading"></div>
            <!-- The table listing the files available for upload/download -->
            <table role="presentation" class="table table-striped">
                <tbody id="hasfile" class="files" data-toggle="modal-gallery" data-target="#modal-gallery"></tbody>
            </table>
            <%--</form>--%>
            </div>
        </div>
    </div>
</div>
<script src="${ctx}/static/js/filetree/jquery.treeview.js" type="text/javascript"></script>
<script type="text/javascript" src="${ctx}/static/js/fancyBox/jquery.mousewheel-3.0.6.pack.js"></script>
<script type="text/javascript" src="${ctx}/static/js/fancyBox/jquery.fancybox.pack.js?v=2.1.0"></script>
<script type="text/javascript" src="${ctx}/static/js/fancyBox/helpers/jquery.fancybox-buttons.js?v=2.1.0"></script>
<script type="text/javascript" src="${ctx}/static/js/fancyBox/helpers/jquery.fancybox-thumbs.js?v=2.1.0"></script>
<script type="text/javascript" src="${ctx}/static/js/main.js?v=0.0.1"></script>
<script type="text/javascript">
    $(function() {
        //分页
        var files = $("#file-items");
        var pager = $("#pagination");
        PageClick = function (nodeId, pageIndex, total, spanInterval) {
            //索引从1开始
            //将当前页索引转为int类型
            var intPageIndex = parseInt(pageIndex);
            var limit = 8;//每页显示文章数量

            $.ajax({
                url: "${ctx}/api/file/list/"+nodeId+"?offset=" + (intPageIndex - 1) * limit + "&limit=" + limit,
                timeout:3000
            }).done(function (data) {
                    //加载文件
                    files.html("");
                    $.each(data, function (index, item) {
                        var row="<tr><td><label class='checkbox'><input type='checkbox' name='subBox' value=''></label></td><td><a href='${ctx}/file/get/"+item.id+"'>"+item.customName+"</a></td><td>不支持</td><td>不支持</td><td>"+ChangeDateFormat(item.createdDate)+"</td><td>"+item.md5+"</td><td><a href='#'><i class='icon-star' title='收藏'></i></a> | ";
                        if (item.status)
                            row += "<a href='${ctx}/file/get/"+item.id+"'><i class='icon-download' title='下载'></i></a> | ";
                        if (item.shared)
                            row += "<a href='${ctx}/share/create/"+item.id+"'><i class='icon-share' title='分享'></i></a> | ";
                        row = row.substr(0, row.length-3);
                        row += "</td>";
                        // TODO 判断管理员身份
                        row += "<td><a href='${ctx}/file/edit/"+item.id+"'><i class='icon-pencil' title='修改'></i></a> | <a href='#'><i class='icon-eye-close' title='禁止下载'></i></a> | <a href='${ctx}/file/delete/"+item.id+"'><i class='icon-remove' title='删除'></i></a></td></tr>";
                        files.append(row);
                    });

                    //将总记录数结果 得到 总页码数
                    var pageS = total;
                    if (pageS % limit == 0) pageS = pageS / limit;
                    else pageS = parseInt(total / limit) + 1;

                    //设置分页的格式  这里可以根据需求完成自己想要的结果
                    var interval = parseInt(spanInterval); //设置间隔
                    var start = Math.max(1, intPageIndex - interval); //设置起始页
                    var end = Math.min(intPageIndex + interval, pageS);//设置末页

                    if (intPageIndex < interval + 1) {
                        end = (2 * interval + 1) > pageS ? pageS : (2 * interval + 1);
                    }

                    if ((intPageIndex + interval) > pageS) {
                        start = (pageS - 2 * interval) < 1 ? 1 : (pageS - 2 * interval);
                    }

                    //生成页码
                    pager.html("");
                    for (var j = start; j < end + 1; j++) {
                        if (j == intPageIndex) {
                            pager.append("<li class='active'><a href='#'>" + j + "</a></li>");
                        } else {
                            var a = $("<li><a href='#'>" + j + "</a></li>").click(function () {
                                PageClick(nodeId, $(this).text(), total, spanInterval);
                            });
                            pager.append(a);
                        } //else
                    } //for
            });
        };

        // 目录树
        $("#browser").treeview();
        $(".leafnode").click(function(){
            $("#file-list").show();
            nodeId = $(this).attr("id");
            $.ajax({
                url: "${ctx}/api/file/count/"+nodeId,
                timeout:3000
            }).done(function (data) {
                PageClick(nodeId, 1, data, 5);
            });
        });

        // 图片展示控制
        $(".fancybox").fancybox();
        $(".thumbnail").click(function() {
            $.fancybox.open([
                {
                    href : '${ctx}/static/images/psb.jpg',
                    title : 'My title'
                }, {
                    href : '${ctx}/static/images/psb1.jpg',
                    title : '1st title'
                }, {
                    href : '${ctx}/static/images/psb2.jpg',
                    title : '2nd title'
                }, {
                    href : '${ctx}/static/images/psb3.jpg',
                    title:'3td title'
                }
            ], {
                helpers : {
                    thumbs : {
                        width: 75,
                        height: 50
                    }
                }
            });
        });

        // 文件上传fileupload
        $("#choosefile").change(function(){
            $("#gp_information").show();
            var filePath=$("#choosefile").val();
            var pre = filePath.substr(filePath.lastIndexOf('\\')+1);
            var realName =pre.substr(0,10);

            if(node.type==null) {
                var upload="<tr class='template-upload fade in'><td class='preview'><span class='fade' style='width: 6px'></span></td><td class='name'><span id='realName' title='"+pre+"'>" + realName + "</span></td><td class='size'><span id='size'></span></td><td><div class='progress progress-success progress-striped active' role='progressbar' aria-valuemin='0' aria-valuemax='100' aria-valuenow='0'><div class='bar' style='width:0%;'></div></div></td><td class='start'><button class='btn btn-primary'><i class='icon-upload icon-white'></i><span>开始上传</span></button></td><td class='cancel'><button class='btn btn-warning'><i class='icon-ban-circle icon-white'></i><span>取消</span></button></td></tr>";
                $("#hasfile").append(upload);
            }else{
                newAlert("block","请选择正确分类");
            }
        });
    })
</script>
</body>
</html>