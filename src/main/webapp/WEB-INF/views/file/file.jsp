<%--
  Created by IntelliJ IDEA.
  User: zhangnan
  Date: 12-8-26
  Time: 下午4:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="ZN">
<head>
    <title>文件管理</title>
    <link rel="stylesheet" href="${ctx}/static/js/filetree/jquery.treeview.css"/>
    <script src="${ctx}/static/js/filetree/jquery.treeview.js" type="text/javascript"></script>
    <script src="${ctx}/static/js/filetree/jquery.treeview.edit.js" type="text/javascript"></script>
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
                <ul id="browser" class="filetree treeview">
                    <li class="collapsable"><div class="hitarea collapsable-hitarea"></div><span class="folder">视频</span>
                        <ul>
                            <li class="last"><span class="folder">视频 1.1</span></li>
                        </ul>
                    </li>
                    <li class="collapsable"><div class="hitarea collapsable-hitarea"></div><span class="folder">图片</span>
                        <ul>
                            <li class="collapsable"><div class="hitarea collapsable-hitarea"></div><span class="folder">图片 2.1</span>
                                <ul>
                                    <li><span class="folder">图片 2.1.1</span></li>
                                    <li class="last"><span class="folder">图片 2.1.2</span></li>
                                </ul>
                            </li>
                            <li class="last"><span class="folder">图片 2.2</span></li>
                        </ul>
                    </li>
                    <li class="closed expandable"><div class="hitarea closed-hitarea expandable-hitarea"></div><span class="folder">文档</span>
                        <ul style="display: none; ">
                            <li class="last"><span class="folder">文档 3.1</span></li>
                        </ul>
                    </li>
                </ul>
            </div>
        </div>
        <div class="span9 columns">
            <div class="hero-unit">
                <div class="bs-docs-example">
                      <%--//文件信息列表--%>
                    <table class="table table-striped">
                        <thead>
                        <tr>
                            <th><label class="checkbox"><input type="checkbox" value=""></label></th>
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
                            <th><label class="checkbox"><input type="checkbox" value=""></label> </th>
                            <td>1</td>
                            <td>Mark</td>
                            <td>Otto</td>
                            <td>@mdo</td>
                            <th>大小</th>
                            <th>时长</th>
                            <th><a href="#"><i class="icon-tags" title="修改"></i></a></th>
                            <th><a href="#"><i class="icon-remove" title="删除"></i></a></th>
                            <th><a href="#"><i class="icon-hand-right" title="分享"></i></a> <a href="#"><i class="icon-star" title="重点标记"></i></a> <a href="#"><i class="icon-download-alt" title="下载"></i></a></th>
                        </tr>
                        <tr>
                            <th><label class="checkbox"><input type="checkbox" value=""></label> </th>
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
                            <th><label class="checkbox"><input type="checkbox" value=""></label> </th>
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
                    </table>
                       <%--//图片展示效果--%>
                    <div id="myCarousel" class="carousel slide">
                        <div class="carousel-inner">
                            <div class="item active">
                                <img src="${ctx}/static/images/psb.jpg" alt="">
                                <div class="carousel-caption">
                                    <h4>图片一</h4>
                                </div>
                            </div>
                            <div class="item">
                                <img src="${ctx}/static/images/psb.jpg" alt="">
                                <div class="carousel-caption">
                                    <h4>图片二</h4>
                                </div>
                            </div>
                            <div class="item">
                                <img src="${ctx}/static/images/psb.jpg" alt="">
                                <div class="carousel-caption">
                                    <h4>图片三</h4>
                                </div>
                            </div>
                        </div>
                        <a class="left carousel-control" href="#myCarousel" data-slide="prev">‹</a>
                        <a class="right carousel-control" href="#myCarousel" data-slide="next">›</a>
                    </div>

                      <%--//暂定图片显示--%>
                    <%--<div class="row-fluid team">--%>
                        <%--<p class="span2 thumbnail">--%>
                            <%--<a class="fancybox-effects" href="#{ctx}/static/images/headPic/1-big.jpg" title="1"><img src="#{ctx}/static/images/headPic/48414130.png" width="120px" height="120px"></a>--%>
                        <%--</p>--%>
                        <%--<p class="span2 thumbnail">--%>
                            <%--<a class="fancybox-effects" href="#{ctx}/static/images/headPic/1-big.jpg" title="1"><img src="#{ctx}/static/images/headPic/48414130.png" width="120px" height="120px"></a>--%>
                        <%--</p>--%>
                    <%--</div>--%>
                </div>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript">
    $(function(){
        $("#browser").treeview();
    })
</script>
</body>
</html>