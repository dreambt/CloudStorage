/*!
 * Buttons helper for fancyBox
 * version: 1.0.3
 * @requires fancyBox v2.0 or later
 *
 * Usage:
 *     $(".fancybox").fancybox({
 *         helpers : {
 *             buttons: {
 *                 position : 'top'
 *             }
 *         }
 *     });
 *
 * Options:
 *     tpl - HTML template
 *     position - 'top' or 'bottom'
 *
 */
(function(c){var d=c.fancybox;d.helpers.buttons={tpl:'<div id="fancybox-buttons"><ul><li><a class="btnPrev" title="Previous" href="javascript:;"></a></li><li><a class="btnPlay" title="Start slideshow" href="javascript:;"></a></li><li><a class="btnNext" title="Next" href="javascript:;"></a></li><li><a class="btnToggle" title="Toggle size" href="javascript:;"></a></li><li><a class="btnClose" title="Close" href="javascript:jQuery.fancybox.close();"></a></li></ul></div>',list:null,buttons:null,beforeLoad:function(b,a){if(b.skipSingle&&a.group.length<2){a.helpers.buttons=false;a.closeBtn=true;return}a.margin[b.position==="bottom"?2:0]+=30},onPlayStart:function(){if(this.buttons){this.buttons.play.attr("title","Pause slideshow").addClass("btnPlayOn")}},onPlayEnd:function(){if(this.buttons){this.buttons.play.attr("title","Start slideshow").removeClass("btnPlayOn")}},afterShow:function(f,b){var a=this.buttons;if(!a){this.list=c(f.tpl||this.tpl).addClass(f.position||"top").appendTo("body");a={prev:this.list.find(".btnPrev").click(d.prev),next:this.list.find(".btnNext").click(d.next),play:this.list.find(".btnPlay").click(d.play),toggle:this.list.find(".btnToggle").click(d.toggle)}}if(b.index>0||b.loop){a.prev.removeClass("btnDisabled")}else{a.prev.addClass("btnDisabled")}if(b.loop||b.index<b.group.length-1){a.next.removeClass("btnDisabled");a.play.removeClass("btnDisabled")}else{a.next.addClass("btnDisabled");a.play.addClass("btnDisabled")}this.buttons=a;this.onUpdate(f,b)},onUpdate:function(f,b){var a;if(!this.buttons){return}a=this.buttons.toggle.removeClass("btnDisabled btnToggleOn");if(b.canShrink){a.addClass("btnToggleOn")}else{if(!b.canExpand){a.addClass("btnDisabled")}}},beforeClose:function(){if(this.list){this.list.remove()}this.list=null;this.buttons=null}}}(jQuery));