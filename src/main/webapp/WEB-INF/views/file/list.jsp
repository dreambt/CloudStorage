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
    <%--目录树--%>
    <link rel="stylesheet" href="${ctx}/static/js/filetree/jquery.treeview.css"/>
    <script src="${ctx}/static/js/filetree/jquery.treeview.js" type="text/javascript"></script>
    <script src="${ctx}/static/js/filetree/jquery.treeview.edit.js" type="text/javascript"></script>
    <%--视频播放--%>
    <link type="text/css" href="${ctx}/static/js/jPlayer/skin/jplayer.blue.monday.css" rel="stylesheet" />
    <script type="text/javascript" src="${ctx}/static/js/jPlayer/jquery.jplayer.min.js"></script>
    <%--文件上传--%>
    <link rel="stylesheet" href="${ctx}/static/js/fileupload/jquery.fileupload-ui.css"/>

</head>
<body>
<div class="page">
    <div class="page-header">
        <h2>
            文件管理
            <small>欢迎进入文件管理</small>
        </h2>
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
                        <input type="checkbox" class="toggle">全选</input>
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
                    <tbody id="hasfile" class="files" data-toggle="modal-gallery" data-target="#modal-gallery" style="display: none">
                    <tr class="template-upload fade in">
                        <td class="preview"><span class="fade"></span></td>
                        <td class="name"><span id="realName"></span></td>
                        <td class="size"><span id="size"></span></td>

                        <td>
                            <div class="progress progress-success progress-striped active" role="progressbar" aria-valuemin="0" aria-valuemax="100" aria-valuenow="0"><div class="bar" style="width:0%;"></div></div>
                        </td>
                        <td class="start">
                            <button class="btn btn-primary">
                                <i class="icon-upload icon-white"></i>
                                <span>开始上传</span>
                            </button>
                        </td>

                        <td class="cancel">
                            <button class="btn btn-warning">
                                <i class="icon-ban-circle icon-white"></i>
                                <span>取消</span>
                            </button>
                        </td>
                    </tr>
                    </tbody>
                </table>
            <%--</form>--%>
    </div>
    <div class="row">
        <div class="span2 columns">
            <div class="well" style="padding: 8px 0;">
                <%--目录树--%>
                <ul id="browser" class="filetree treeview">
                    <li class="closed expandable"><div class="hitarea closed-hitarea expandable-hitarea"></div><span class="folder">视频</span>
                        <ul>
                            <li class="closed expandable"><div class="hitarea closed-hitarea expandable-hitarea"></div><span class="folder">视频 1.1</span>
                                <ul>
                                    <li class="collapsable hide"><span class="folder">视频 1.11</span></li>
                                </ul>
                            </li>
                        </ul>
                    </li>
                    <li class="closed expandable"><div class="hitarea closed-hitarea expandable-hitarea"></div><span class="folder">图片</span>
                        <ul>
                            <li class="closed expandable"><div class="hitarea closed-hitarea expandable-hitarea"></div><span class="folder">图片 2.1</span>
                                <ul>
                                    <li class="closed expandable"><div class="hitarea closed-hitarea expandable-hitarea"></div><span class="folder">图片 2.1.1</span>
                                        <ul>
                                            <li class="collapsable hide"><span class="folder">图片文件</span></li>
                                        </ul>
                                    </li>
                                    <li class="closed expandable"><div class="hitarea closed-hitarea expandable-hitarea"></div><span class="folder">图片 2.1.2</span>
                                        <ul>
                                             <li class="collapsable hide"><span class="folder">图片文件</span></li>
                                        </ul>
                                    </li>
                                </ul>
                            </li>
                            <li class="closed expandable"><div class="hitarea closed-hitarea expandable-hitarea"></div><span class="folder">图片 2.2</span>
                                <ul>
                                    <li class="collapsable hide"><span class="folder">图片文件</span></li>
                                </ul>
                            </li>
                        </ul>
                    </li>
                    <li class="closed expandable"><div class="hitarea closed-hitarea expandable-hitarea"></div><span class="folder">文档</span>
                        <ul style="display: none; ">
                            <li class="last"><div class="hitarea closed-hitarea expandable-hitarea"></div><span class="folder">文档 3.1</span>
                                <ul style="display: none; ">
                                    <li class="last hide"><span class="folder">文档文件</span></li>
                                </ul>
                            </li>
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
                            <td><a data-toggle="modal" href="#myModal" class="video">视频</a></td>
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
                        <tr>
                            <th>
                                <div class="bs-docs-example">
                                    <button type="button" class="btn btn-mini">批量下载</button>
                                </div>
                            </th>
                        </tr>
                        </tbody>
                    </table>
                       <%--&lt;%&ndash;//图片展示效果&ndash;%&gt;--%>
                    <%--<div id="myCarousel" class="carousel slide">--%>
                        <%--<div class="carousel-inner">--%>
                            <%--<div class="item active">--%>
                                <%--<img src="${ctx}/static/images/psb.jpg" alt="">--%>
                                <%--<div class="carousel-caption">--%>
                                    <%--<h4>图片一</h4>--%>
                                <%--</div>--%>
                            <%--</div>--%>
                            <%--<div class="item">--%>
                                <%--<img src="${ctx}/static/images/psb.jpg" alt="">--%>
                                <%--<div class="carousel-caption">--%>
                                    <%--<h4>图片二</h4>--%>
                                <%--</div>--%>
                            <%--</div>--%>
                            <%--<div class="item">--%>
                                <%--<img src="${ctx}/static/images/psb.jpg" alt="">--%>
                                <%--<div class="carousel-caption">--%>
                                    <%--<h4>图片三</h4>--%>
                                <%--</div>--%>
                            <%--</div>--%>
                        <%--</div>--%>
                        <%--<a class="left carousel-control" href="#myCarousel" data-slide="prev">‹</a>--%>
                        <%--<a class="right carousel-control" href="#myCarousel" data-slide="next">›</a>--%>
                    <%--</div>--%>

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

                <%--视频播放窗口--%>
                <div id="myModal" class="modal hide fade" style="display: none; ">
                    <div class="modal-body">
                        <div style="margin: 0px;padding: 0px">
                            <div id="jp_container_1" class="jp-video">
                                <div class="jp-type-single">
                                    <div id="jquery_jplayer_1" class="jp-jplayer"></div>
                                    <div class="jp-gui">
                                        <div class="jp-video-play">
                                            <a href="javascript:;" class="jp-video-play-icon" tabindex="1">play</a>
                                        </div>
                                        <div class="jp-interface">
                                            <div class="jp-progress">
                                                <div class="jp-seek-bar">
                                                    <div class="jp-play-bar"></div>
                                                </div>
                                            </div>
                                            <div class="jp-current-time"></div>
                                            <div class="jp-duration"></div>
                                            <div class="jp-controls-holder">
                                                <ul class="jp-controls">
                                                    <li><a href="javascript:;" class="jp-play" tabindex="1">play</a></li>
                                                    <li><a href="javascript:;" class="jp-pause" tabindex="1">pause</a></li>
                                                    <li><a href="javascript:;" class="jp-stop" tabindex="1">stop</a></li>
                                                    <li><a href="javascript:;" class="jp-mute" tabindex="1" title="mute">mute</a></li>
                                                    <li><a href="javascript:;" class="jp-unmute" tabindex="1" title="unmute">unmute</a></li>
                                                    <li><a href="javascript:;" class="jp-volume-max" tabindex="1" title="max volume">max volume</a></li>
                                                </ul>
                                                <div class="jp-volume-bar">
                                                    <div class="jp-volume-bar-value"></div>
                                                </div>
                                                <ul class="jp-toggles">
                                                    <li><a href="javascript:;" class="jp-full-screen" tabindex="1" title="full screen">full screen</a></li>
                                                    <li><a href="javascript:;" class="jp-restore-screen" tabindex="1" title="restore screen">restore screen</a></li>
                                                    <li><a href="javascript:;" class="jp-repeat" tabindex="1" title="repeat">repeat</a></li>
                                                    <li><a href="javascript:;" class="jp-repeat-off" tabindex="1" title="repeat off">repeat off</a></li>
                                                </ul>
                                            </div>
                                            <div class="jp-title">
                                                <ul>
                                                    <li>Big Buck Bunny Trailer</li>
                                                </ul>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="jp-no-solution">
                                        <span>Update Required</span>
                                        To play the media you will need to either update your browser to a recent version or update your <a href="http://get.adobe.com/flashplayer/" target="_blank">Flash plugin</a>.
                                    </div>
                                </div>
                            </div>
                        </div>
                     </div>
                </div>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript">
    $(function(){
        $("#browser").treeview();
//            //        checkbox全选与取消
//        $("#checkedAll").click(function(){
//            if($(this).attr("checked")==undefined){
//                $("input[name='subBox']").each(function(){
//                    $(this).attr("checked",false);
//                });
//            }
//            else{
//                $("input[name='subBox']").each(function(){
//                    $(this).attr("checked",true);
//                });
//            }
//        });
                //视频jPlayer
        $("#jquery_jplayer_1").jPlayer({
            ready: function () {
                $(this).jPlayer("setMedia", {
                    m4v: "http://www.jplayer.org/video/m4v/Big_Buck_Bunny_Trailer_480x270_h264aac.m4v",
                    ogv: "http://www.jplayer.org/video/ogv/Big_Buck_Bunny_Trailer_480x270.ogv",
                    poster: "http://www.jplayer.org/video/poster/Big_Buck_Bunny_Trailer_480x270.png"
                });
            },
            swfPath: "/js",
            supplied: "m4v, ogv"
        });
        <%--fileupload--%>
        var i;
        $("#choosefile").change(function(){
            $("#gp_information").show();
            $("#hasfile").show();

            var filePath=$("#choosefile").val();
            $("#realName").text(filePath.substr(filePath.lastIndexOf('\\')+1));
            var upload="<tr>this.append'('<td id='realName'></td>')';this.append'('<td id='size'></td>')'</tr>";

            function findSize(choosefile)
            {
                var lsize;
                var fileInput = $("#"+choosefile)[0];
                var byteSize  = fileInput.files[0].fileSize;
                return ( Math.ceil(byteSize / 1024) ); // Size returned in KB.
                lsize=Math.ceil(byteSize / 1024);
                alert(lsize);
            }
        });
//        function findSize(choosefile)
//        {
//            var lsize;
//            var fileInput = $("#"+choosefile)[0];
//            var byteSize  = fileInput.files[0].fileSize;
//            return ( Math.ceil(byteSize / 1024) ); // Size returned in KB.
//            lsize=Math.ceil(byteSize / 1024);
//            alert(lsize);
//        }


    })
</script>
</body>
</html>