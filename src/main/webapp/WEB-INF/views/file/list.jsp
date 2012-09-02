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
    <%--目录树--%>
    <link rel="stylesheet" href="${ctx}/static/js/filetree/jquery.treeview.css"/>
    <script src="${ctx}/static/js/filetree/jquery.treeview.js" type="text/javascript"></script>
    <script src="${ctx}/static/js/filetree/jquery.treeview.edit.js" type="text/javascript"></script>
    <%--文件上传--%>
    <link rel="stylesheet" href="${ctx}/static/js/fileupload/jquery.fileupload-ui.css"/>
    <%--图片展示--%>
    <link rel="stylesheet" type="text/css" href="${ctx}/static/js/fancyBox/helpers/jquery.fancybox-thumbs.css">
    <link rel="stylesheet" type="text/css" href="${ctx}/static/js/fancyBox/jquery.fancybox.css">
    <script type="text/javascript" src="${ctx}/static/js/fancyBox/helpers/jquery.fancybox-thumbs.js"></script>
    <script type="text/javascript" src="${ctx}/static/js/fancyBox/jquery.mousewheel-3.0.6.pack.js"></script>
    <script type="text/javascript" src="${ctx}/static/js/fancyBox/jquery.fancybox.js"></script>
</head>
<body>
<div class="page">
    <div class="page-header">
        <h2>
            文件管理
            <small>欢迎进入文件管理</small>
        </h2>
    </div>
    <div class="row">
        <div class="span2 columns">
            <div class="well" style="padding: 8px 0;">
                <%--目录树--%>
                <ul id="browser" class="filetree treeview">
                    <%--<li class="closed expandable"><div class="hitarea closed-hitarea expandable-hitarea"></div><span class="folder">视频</span>--%>
                        <%--<ul>--%>
                            <%--<li class="closed expandable"><div class="hitarea closed-hitarea expandable-hitarea"></div><span class="folder">视频 1.1</span>--%>
                                <%--<ul>--%>
                                    <%--<li class="collapsable hide"><span class="folder">视频 1.11</span></li>--%>
                                <%--</ul>--%>
                            <%--</li>--%>
                        <%--</ul>--%>
                    <%--</li>--%>
                    <%--<li class="closed expandable"><div class="hitarea closed-hitarea expandable-hitarea"></div><span class="folder">图片</span>--%>
                        <%--<ul>--%>
                            <%--<li class="closed expandable"><div class="hitarea closed-hitarea expandable-hitarea"></div><span class="folder">图片 2.1</span>--%>
                                <%--<ul>--%>
                                    <%--<li class="closed expandable"><div class="hitarea closed-hitarea expandable-hitarea"></div><span class="folder">图片 2.1.1</span>--%>
                                        <%--<ul>--%>
                                            <%--<li class="collapsable hide"><span class="folder">图片文件</span></li>--%>
                                        <%--</ul>--%>
                                    <%--</li>--%>
                                    <%--<li class="closed expandable"><div class="hitarea closed-hitarea expandable-hitarea"></div><span class="folder">图片 2.1.2</span>--%>
                                        <%--<ul>--%>
                                             <%--<li class="collapsable hide"><span class="folder">图片文件</span></li>--%>
                                        <%--</ul>--%>
                                    <%--</li>--%>
                                <%--</ul>--%>
                            <%--</li>--%>
                            <%--<li class="closed expandable"><div class="hitarea closed-hitarea expandable-hitarea"></div><span class="folder">图片 2.2</span>--%>
                                <%--<ul>--%>
                                    <%--<li class="collapsable hide"><span class="folder">图片文件</span></li>--%>
                                <%--</ul>--%>
                            <%--</li>--%>
                        <%--</ul>--%>
                    <%--</li>--%>
                    <%--<li class="closed expandable"><div class="hitarea closed-hitarea expandable-hitarea"></div><span class="folder">文档</span>--%>
                        <%--<ul style="display: none; ">--%>
                            <%--<li class="last"><div class="hitarea closed-hitarea expandable-hitarea"></div><span class="folder">文档 3.1</span>--%>
                                <%--<ul style="display: none; ">--%>
                                    <%--<li class="last hide"><span class="folder">文档文件</span></li>--%>
                                <%--</ul>--%>
                            <%--</li>--%>
                        <%--</ul>--%>
                    <%--</li>--%>
                </ul>
            </div>
        </div>
        <div class="span9 columns">
            <div class="hero-unit">
            <%--文件上传--%>
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
                <tbody id="hasfile" class="files" data-toggle="modal-gallery" data-target="#modal-gallery">
                <%--<tr class="template-upload fade in">--%>
                    <%--<td class="preview"><span class="fade" style="width: 6px"></span></td>--%>
                    <%--<td class="name"><span id="realName"></span></td>--%>
                    <%--<td class="size"><span id="size"></span></td>--%>

                    <%--<td>--%>
                        <%--<div class="progress progress-success progress-striped active" role="progressbar" aria-valuemin="0" aria-valuemax="100" aria-valuenow="0"><div class="bar" style="width:0%;"></div></div>--%>
                    <%--</td>--%>
                    <%--<td class="start">--%>
                        <%--<button class="btn btn-primary">--%>
                            <%--<i class="icon-upload icon-white"></i>--%>
                            <%--<span>开始上传</span>--%>
                        <%--</button>--%>
                    <%--</td>--%>

                    <%--<td class="cancel">--%>
                        <%--<button class="btn btn-warning">--%>
                            <%--<i class="icon-ban-circle icon-white"></i>--%>
                            <%--<span>取消</span>--%>
                        <%--</button>--%>
                    <%--</td>--%>
                <%--</tr>--%>
                </tbody>
            </table>
            <%--</form>--%>
                <div class="bs-docs-example">
                      <%--//文件信息列表--%>
                    <table class="table table-striped">
                        <thead>
                        <tr>
                            <th><label class="checkbox"><input id="checkedAll" type="checkbox" value=""></label></th>
                            <th>#</th>
                            <th>名称</th>
                            <th>日期</th>
                            <th>类型</th>
                            <th>大小</th>
                            <th>时长</th>
                            <th>修改</th>
                            <th>删除</th>
                            <th>更多操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <th><label class="checkbox"><input type="checkbox" name="subBox" value=""></label> </th>
                            <td>1</td>
                            <td><a data-toggle="modal" href="${ctx}/file/get/1" class="video">视频</a></td>
                            <td>Otto</td>
                            <td>@mdo</td>
                            <th>大小</th>
                            <th>时长</th>
                            <th><a href="#"><i class="icon-tags" title="修改"></i></a></th>
                            <th><a href="#"><i class="icon-remove" title="删除"></i></a></th>
                            <th><a href="#"><i class="icon-hand-right" title="分享"></i></a> <a href="#"><i class="icon-star" title="重点标记"></i></a> <a href="#"><i class="icon-download-alt" title="下载"></i></a></th>
                        </tr>
                        <tr>
                            <th><label class="checkbox"><input type="checkbox" name="subBox" value=""></label> </th>
                            <td>2</td>
                            <td>Jacob</td>
                            <td>Thornton</td>
                            <td>@fat</td>
                            <th>大小</th>
                            <th>时长</th>
                            <th><a href="#"><i class="icon-tags" title="修改"></i></a></th>
                            <th><a href="#"><i class="icon-remove" title="删除"></i></a></th>
                            <th><a href="#"><i class="icon-hand-right" title="分享"></i></a> <a href="#"><i class="icon-star" title="重点标记"></i></a> <a href="#"><i class="icon-download-alt" title="下载"></i></a></th>
                        </tr>
                        <tr>
                            <th><label class="checkbox"><input type="checkbox" name="subBox" value=""></label> </th>
                            <td>3</td>
                            <td>Larry</td>
                            <td>the Bird</td>
                            <td>@twitter</td>
                            <th>大小</th>
                            <th>时长</th>
                            <th><a href="#"><i class="icon-tags" title="修改"></i></a></th>
                            <th><a href="#"><i class="icon-remove" title="删除"></i></a></th>
                            <th><a href="#"><i class="icon-hand-right" title="分享"></i></a> <a href="#"><i class="icon-star" title="重点标记"></i></a> <a href="#"><i class="icon-download-alt" title="下载"></i></a></th>
                        </tr>
                        </tbody>
                        <p class="bs-docs-example">
                            <button type="button" class="btn btn-mini">批量下载</button>
                        </p>
                    </table>
                </div>

                <%--图片显示列表--%>
                <div class="row-fluid">
                    <ul id="album" class="thumbnails">
                        <li class="span3 thumbnail">
                            <a id="fancybox-manual" href="javascript:;"><img src="${ctx}/static/images/psb.jpg" alt=""></a>
                        </li>
                        <li class="span3 thumbnail">
                            <a href="javascript:;"><img src="${ctx}/static/images/psb1.jpg" alt=""></a>
                        </li>
                        <li class="span3 thumbnail">
                            <a href="javascript:;"><img src="${ctx}/static/images/psb2.jpg" alt=""></a>
                        </li>
                        <li class="span3 thumbnail">
                            <a href="javascript:;"><img src="${ctx}/static/images/psb3.jpg" alt=""></a>
                        </li>
                    </ul>
                </div>
                <%--图片分页--%>
                <div class="pagination pagination-right">
                    <ul id="pagination">
                        <li><a href="#">1</a></li>
                        <li><a href="#">2</a></li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript">
    $(function() {
        $("#browser").treeview();

        //        checkbox全选与取消
        $("#checkedAll").click(function(){
            if($(this).attr("checked")==undefined){
                $("input[name='subBox']").each(function(){
                    $(this).attr("checked",false);
                });
            }
            else{
                $("input[name='subBox']").each(function(){
                    $(this).attr("checked",true);
                });
            }
        });
        // 图片展示控制  *********************

        $(".fancybox").fancybox();
        /*
         *  Thumbnail helper. Disable animations, hide close button, arrows and slide to next gallery item if clicked
         */

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

        <!-- 文件上传fileupload -->
        $("#choosefile").change(function(){
            $("#gp_information").show();
            var filePath=$("#choosefile").val();
            var pre = filePath.substr(filePath.lastIndexOf('\\')+1);
            var realName =pre.substr(0,10);
            var upload="<tr class='template-upload fade in'><td class='preview'><span class='fade' style='width: 6px'></span></td><td class='name'><span id='realName' title='"+pre+"'>" + realName + "</span></td><td class='size'><span id='size'></span></td><td><div class='progress progress-success progress-striped active' role='progressbar' aria-valuemin='0' aria-valuemax='100' aria-valuenow='0'><div class='bar' style='width:0%;'></div></div></td><td class='start'><button class='btn btn-primary'><i class='icon-upload icon-white'></i><span>开始上传</span></button></td><td class='cancel'><button class='btn btn-warning'><i class='icon-ban-circle icon-white'></i><span>取消</span></button></td></tr>";
            $("#hasfile").append(upload);
        });

        $.ajax({
            url:"${ctx}/node/getChildren/0",
            success:(function(data){
                $("#browser").html("");
                var browser="<li class='closed expandable'><div class='hitarea closed-hitarea expandable-hitarea'></div><span class='folder'></span><ul><li class='closed expandable'><div class='hitarea closed-hitarea expandable-hitarea'></div><span class='folder'>视频 1.1</span><ul><li class='collapsable hide'><span class='folder'>视频 1.11</span></li></ul></li></ul></li>";
                $("#browser").append(browser);
                // $("#browser").append($("<li class='closed expandable'><div class='hitarea closed-hitarea expandable-hitarea'></div><span class='folder'></span><ul><li class='closed expandable'><div class='hitarea closed-hitarea expandable-hitarea'></div><span class='folder'>视频 1.1</span><ul><li class='collapsable hide'><span class='folder'>视频 1.11</span></li></ul></li></ul></li>"));
            })
        });
    })
</script>
</body>
</html>