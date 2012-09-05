<%--
  Created by IntelliJ IDEA.
  User: zhangnan
  Date: 12-8-31
  Time: 下午9:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>视频播放</title>
    <%--视频播放--%>
    <link type="text/css" href="${ctx}/static/js/jPlayer/skin/jplayer.blue.monday.css" rel="stylesheet"/>
    <script type="text/javascript" src="${ctx}/static/js/jPlayer/jquery.jplayer.min.js"></script>
    <script type="text/javascript" src="${ctx}/static/js/jPlayer/add-on/jplayer.playlist.min.js"></script>
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.6/jquery.min.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {

            new jPlayerPlaylist({
                jPlayer:"#jquery_jplayer_1",
                cssSelectorAncestor:"#jp_container_1"
            }, [
                {
                    title:"Cro Magnon Man",
                    artist:"The Stark Palace",
                    mp3:"http://www.jplayer.org/audio/mp3/TSP-01-Cro_magnon_man.mp3",
                    oga:"http://www.jplayer.org/audio/ogg/TSP-01-Cro_magnon_man.ogg",
                    poster:"http://www.jplayer.org/audio/poster/The_Stark_Palace_640x360.png"
                },
                {
                    title:"Your Face",
                    artist:"The Stark Palace",
                    mp3:"http://www.jplayer.org/audio/mp3/TSP-05-Your_face.mp3",
                    oga:"http://www.jplayer.org/audio/ogg/TSP-05-Your_face.ogg",
                    poster:"http://www.jplayer.org/audio/poster/The_Stark_Palace_640x360.png"
                },
                {
                    title:"Hidden",
                    artist:"Miaow",
                    mp3:"http://www.jplayer.org/audio/mp3/Miaow-02-Hidden.mp3",
                    oga:"http://www.jplayer.org/audio/ogg/Miaow-02-Hidden.ogg",
                    poster:"http://www.jplayer.org/audio/poster/Miaow_640x360.png"
                },
                {
                    title:"Big Buck Bunny Trailer",
                    artist:"Blender Foundation",
                    m4v:"http://www.jplayer.org/video/m4v/Big_Buck_Bunny_Trailer.m4v",
                    ogv:"http://www.jplayer.org/video/ogv/Big_Buck_Bunny_Trailer.ogv",
                    webmv:"http://www.jplayer.org/video/webm/Big_Buck_Bunny_Trailer.webm",
                    poster:"http://www.jplayer.org/video/poster/Big_Buck_Bunny_Trailer_480x270.png"
                },
                {
                    title:"Finding Nemo Teaser",
                    artist:"Pixar",
                    m4v:"http://www.jplayer.org/video/m4v/Finding_Nemo_Teaser.m4v",
                    ogv:"http://www.jplayer.org/video/ogv/Finding_Nemo_Teaser.ogv",
                    webmv:"http://www.jplayer.org/video/webm/Finding_Nemo_Teaser.webm",
                    poster:"http://www.jplayer.org/video/poster/Finding_Nemo_Teaser_640x352.png"
                },
                {
                    title:"Cyber Sonnet",
                    artist:"The Stark Palace",
                    mp3:"http://www.jplayer.org/audio/mp3/TSP-07-Cybersonnet.mp3",
                    oga:"http://www.jplayer.org/audio/ogg/TSP-07-Cybersonnet.ogg",
                    poster:"http://www.jplayer.org/audio/poster/The_Stark_Palace_640x360.png"
                },
                {
                    title:"Incredibles Teaser",
                    artist:"Pixar",
                    m4v:"http://www.jplayer.org/video/m4v/Incredibles_Teaser.m4v",
                    ogv:"http://www.jplayer.org/video/ogv/Incredibles_Teaser.ogv",
                    webmv:"http://www.jplayer.org/video/webm/Incredibles_Teaser.webm",
                    poster:"http://www.jplayer.org/video/poster/Incredibles_Teaser_640x272.png"
                },
                {
                    title:"Tempered Song",
                    artist:"Miaow",
                    mp3:"http://www.jplayer.org/audio/mp3/Miaow-01-Tempered-song.mp3",
                    oga:"http://www.jplayer.org/audio/ogg/Miaow-01-Tempered-song.ogg",
                    poster:"http://www.jplayer.org/audio/poster/Miaow_640x360.png"
                },
                {
                    title:"Lentement",
                    artist:"Miaow",
                    mp3:"http://www.jplayer.org/audio/mp3/Miaow-03-Lentement.mp3",
                    oga:"http://www.jplayer.org/audio/ogg/Miaow-03-Lentement.ogg",
                    poster:"http://www.jplayer.org/audio/poster/Miaow_640x360.png"
                }
            ], {
                swfPath:"js",
                supplied:"webmv, ogv, m4v, oga, mp3"
            });

        });
    </script>
</head>
<body>
<div class="page">
    <div class="page-header">
        <h2>
            视频点播
            <small>欢迎进入视频点播</small>
        </h2>
    </div>
    <%--加上播放列表--%>
    <div class="row">
        <div class="span10 hero-unit">
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
</body>
</html>