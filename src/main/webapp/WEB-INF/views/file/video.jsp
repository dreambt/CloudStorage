<%--
  视频展示
  User: zhangnan
  Date: 12-8-31
  Time: 下午9:09
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>视频播放</title>
    <link type="text/css" href="${ctx}/static/js/jPlayer/skin/jplayer.blue.monday.css" rel="stylesheet"/>
</head>
<body>
<div class="page">
    <div class="page-header">
        <h2>
            视频点播 <small>欢迎进入视频点播</small>
        </h2>
    </div>
    <div class="row">
        <div class="span12">
            <div id="jp_container_1" class="jp-video jp-video-270p">
                <div class="jp-type-playlist">
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
                                    <li><a href="javascript:;" class="jp-previous" tabindex="1">previous</a></li>
                                    <li><a href="javascript:;" class="jp-play" tabindex="1">play</a></li>
                                    <li><a href="javascript:;" class="jp-pause" tabindex="1">pause</a></li>
                                    <li><a href="javascript:;" class="jp-next" tabindex="1">next</a></li>
                                    <li><a href="javascript:;" class="jp-stop" tabindex="1">stop</a></li>
                                    <li><a href="javascript:;" class="jp-mute" tabindex="1" title="mute">mute</a></li>
                                    <li><a href="javascript:;" class="jp-unmute" tabindex="1" title="unmute">unmute</a></li>
                                    <li><a href="javascript:;" class="jp-volume-max" tabindex="1" title="max volume">max volume</a>
                                    </li>
                                </ul>
                                <div class="jp-volume-bar">
                                    <div class="jp-volume-bar-value"></div>
                                </div>
                                <ul class="jp-toggles">
                                    <li><a href="javascript:;" class="jp-full-screen" tabindex="1" title="full screen">full
                                        screen</a></li>
                                    <li><a href="javascript:;" class="jp-restore-screen" tabindex="1" title="restore screen">restore
                                        screen</a></li>
                                    <li><a href="javascript:;" class="jp-shuffle" tabindex="1" title="shuffle">shuffle</a></li>
                                    <li><a href="javascript:;" class="jp-shuffle-off" tabindex="1" title="shuffle off">shuffle
                                        off</a></li>
                                    <li><a href="javascript:;" class="jp-repeat" tabindex="1" title="repeat">repeat</a></li>
                                    <li><a href="javascript:;" class="jp-repeat-off" tabindex="1" title="repeat off">repeat off</a>
                                    </li>
                                </ul>
                            </div>
                            <div class="jp-title">
                                <ul>
                                    <li></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                    <div class="jp-playlist">
                        <ul>
                            <!-- The method Playlist.displayPlaylist() uses this unordered list -->
                            <li></li>
                        </ul>
                    </div>
                    <div class="jp-no-solution">
                        <span>Update Required</span>
                        To play the media you will need to either update your browser to a recent version or update your <a
                            href="http://get.adobe.com/flashplayer/" target="_blank">Flash plugin</a>.
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript" src="${ctx}/min?t=js&f=/js/jPlayer/jquery.jplayer.min.js,/js/jPlayer/add-on/jplayer.playlist.min.js"></script>
<script type="text/javascript">
    $(document).ready(function () {
        new jPlayerPlaylist({
            jPlayer:"#jquery_jplayer_1",
            cssSelectorAncestor:"#jp_container_1"
        }, [
            {
                title:"${file.customName}",
                artist:"纪柏涛",
                //m4v:"${ctx}/static-content?contentPath=7c2ca1a3139b6a1af1f3213cee3a11ac4d4fdf3b.mp4",
                m4v:"${ctx}/file/get/${file.fileKey}",
                poster:"http://www.jplayer.org/audio/poster/The_Stark_Palace_640x360.png"
            }
        ], {
            swfPath:"js",
            supplied:"webmv, ogv, m4v, oga, mp3",
            size: {
                width: "640px",
                height: "360px",
                cssClass: "jp-video-360p"
            }
        });
    });
</script>
</body>
</html>